import threading
from bs4 import BeautifulSoup
import requests
from WikiReader import WikiReader
from lxml import html


class StockPriceTrack():
    def __init__(self,symbol):
        self.symbol=symbol
        self.url=f'https://finance.yahoo.com/quote/{symbol}.NS'
    
    def getprice(self):
        print(self.symbol)
        req=requests.get(self.url)
        page_contents=html.fromstring(req.text)
        price=page_contents.xpath('//*[@id="quote-header-info"]/div[3]/div[1]/div/span[1]')[0]
        print(price)


SPT=StockPriceTrack('M&M')
SPT.getprice()







        
