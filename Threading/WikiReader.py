from pyexpat import features
import threading
import requests
from bs4 import BeautifulSoup


class WikiReader():

    def __init__(self):
        self.url='https://en.wikipedia.org/wiki/NIFTY_50'
    
    def getdata(self):
        req=requests.get(self.url)
        return req.text
    
    @staticmethod
    def StockSymbols(phtml):
        symlist=[]
        soup=BeautifulSoup(phtml,features='html.parser')
        table=soup.find('table',id='constituents')
        rows=table.find_all('tr')
        for i in rows[1:]:
            row_data=i.find_all('td')
            row=[x.text for x in row_data]
            symlist.append(row[1])
        return symlist



