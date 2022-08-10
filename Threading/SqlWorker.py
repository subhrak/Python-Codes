import threading
from colorama import Cursor
import requests
import time
import pyodbc
import datetime


class SqlWorkerThreads(threading.Thread):
    
    def __init__(self,input_queue):
        super(SqlWorkerThreads,self).__init__()
        self.input_queue=input_queue
        self.start()
    
    def run(self):
        while True:
            val=self.input_queue.get()
            symbol,price=val
            SI=SqlInsert(symbol=symbol,price=price)
            SI.Insert()
            self.input_queue.task_done()
            if self.input_queue.empty():
                break


class SqlInsert():

    def __init__(self,symbol,price):
        self.symbol=symbol
        self.price=price


    def Insert(self):
        conn = pyodbc.connect('Driver={SQL Server};'
                            'Server=DESKTOP-MFHHQJK\SQLEXPRESS;'
                            'Database=loadingtest;'
                            'Trusted_Connection=yes;')

        cursor=conn.cursor()

        SQLCommand = ("INSERT INTO dbo.StockPrice (Symbol,PriceDesc,logtime) VALUES (?,?,?);") 
        Values = [self.symbol,self.price,datetime.datetime.utcnow()]

        #Processing Query    
        cursor.execute(SQLCommand,Values)

        conn.commit()
        print(f"{self.symbol} Price-Data Successfully Inserted")   
        conn.close()
