import threading
from bs4 import BeautifulSoup
import requests
from WikiReader import WikiReader
import time

class StockPriceScheduler(threading.Thread):

    def __init__(self,input_queue,sqlqueue):
            super(StockPriceScheduler,self).__init__()
            self.input_queue=input_queue
            self.sqlqueue=sqlqueue
            self.start()
    
    def run(self):
        while True:
            val=self.input_queue.get()
            
            SPT=StockPriceTrack(val)
            price=SPT.get_price()
            if self.sqlqueue is not None:
                outval=(val,price)
                if price:
                    print(price)
                    self.sqlqueue.put(outval)

            self.input_queue.task_done()
            if self.input_queue.empty():
                break


class StockPriceTrack(threading.Thread):
    
    def __init__(self,symbol):
        super(StockPriceTrack,self).__init__()
        self.symbol=symbol
        self.url=f'https://finance.yahoo.com/quote/{symbol}.NS'
    
    def get_price(self):
        req=requests.get(self.url).text
        soup=BeautifulSoup(req,features='html.parser')
        data=soup.find('div',class_='D(ib) Mend(20px)')
        if data:
            return data.text








        
