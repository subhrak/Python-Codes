import time
from WikiReader import WikiReader
from StockPriceTracker import StockPriceScheduler
from SqlWorker import SqlWorkerThreads
import queue

def main():
    start=time.time()

    print('Process Start')
    wr=WikiReader()
    symbols=wr.StockSymbols(wr.getdata())
    currentworkers=[]

    q=queue.Queue()
    sqlqueue =queue.Queue()

    schedulerthreads=[]
    sqlthreads=[]

    for i in range(6):
        stockpricescheduler=StockPriceScheduler(q,sqlqueue)
        schedulerthreads.append(stockpricescheduler)

    for i in range(6):
        sqlworkerthreads=SqlWorkerThreads(input_queue=sqlqueue)
        sqlthreads.append(sqlworkerthreads)

    for symbol in symbols:
        q.put(symbol)   

    for i in range(len(schedulerthreads)):
        schedulerthreads[i].join()

    for i in range(len(sqlthreads)):
        sqlthreads[i].join()

    end=time.time()

    print(f'Price Retrieval Completed in {end-start} secs')
 
main()
