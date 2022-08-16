from multiprocessing import Queue,Pool,cpu_count
import  pandas as pd
import os
import time
import urllib
import sqlalchemy as sa
from sqlalchemy import text as sa_text
import pyodbc
import math
from functools import partial
import glob


def main():
    
    #Enter path for files
    filepath='C:\\Users\\Subhro\\OneDrive\\Desktop\\MultiProcessing'

    #Establish SQL connection
    #Truncate table
    connection_string='Driver={SQL Server};'+'Server=DESKTOP-EIFSKOH;'+'Database=CUSTOMERDW;'+'Trusted_Connection=yes;'
    conn=f"mssql+pyodbc:///?odbc_connect={urllib.parse.quote_plus(connection_string)}"
    engine=sa.create_engine(conn)
    engine.execute(sa_text('Truncate table dbo.Sales').execution_options(autocommit=True))
    
    #read multiple CSV Files in one dataframe
    df=CSVReader(filepath)
    
    print(len(df))

    #Insert data normally
    start=time.time()
    #SQLOperations(df)

    print(f'Time taken to load data into SQL Synchronously= {time.time()-start} seconds')

    chunksizelist=[25000,50000,75000,100000]
    for c in chunksizelist:
        #Insert data using multiprocessing chunks
        dflist=split_dataframe(df,c)

        #Truncate table again
        engine.execute(sa_text('Truncate table dbo.Sales').execution_options(autocommit=True))

        start=time.time()
        #use multiprocessing to load data

        with Pool(max(1,cpu_count()-1)) as pool:
            r=pool.map(SQLOperations,dflist)
            
        print(f'Time taken to load data into SQL ASynchronously = {time.time()-start} seconds in {c} chunks')
 


def SQLOperations(df):

    connection_string='Driver={SQL Server};'+'Server=DESKTOP-EIFSKOH;'+'Database=CUSTOMERDW;'+'Trusted_Connection=yes;'
    conn=f"mssql+pyodbc:///?odbc_connect={urllib.parse.quote_plus(connection_string)}"
    engine=sa.create_engine(conn)
    
    print(f'{os.getpid()} Process is loading data')
    #load data to SQL Directly
    start=time.time()
    df.to_sql('Sales',engine,schema='dbo',if_exists='append',index=False,chunksize=10000)
    return time.time()-start

# input - df: a Dataframe, chunkSize: the chunk size
# output - a list of DataFrame
# purpose - splits the DataFrame into smaller chunks
def split_dataframe(df,chunk_size):
    chunks = list()
    num_chunks = math.ceil(len(df) / chunk_size)  
    for i in range(num_chunks):
        chunks.append(df[i*chunk_size:(i+1)*chunk_size])
    return chunks

def CSVReader(path):

    csvfiles=glob.glob(path + "/*.csv")
    dlist=[]
    for filepath in csvfiles:
        dlist.append(pd.read_csv(filepath))
    df=pd.concat(dlist)
    df=df.astype(str)

    return df
    
    

if __name__=='__main__':
    main()
