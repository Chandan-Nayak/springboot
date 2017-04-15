#!/usr/bin/python
# This agent is designed to gather system information and push it to the collectors for processing.
# Currently using psutil

from __future__ import print_function
import psutil
from datetime import datetime
import socket 
import requests
import os
import time


#Lets set a timestamp object
ts = datetime.now().strftime("%Y%m%d%H%M%S")

#Lets grab our hostname for and use it to create a unique filename for our collector
# hostname = socket.gethostname()
# # log = "/tmp/%s%s" % (hostname,ts)
# log = "/tmp/%s.%s" % (hostname,'info')
# output = open(log, 'ab+')

#Lets create a function to store performance information from about CPU
def cpu():
    
    cpu = []
    #Now lets parse system performance stats
    cpu.append(ts)
    cpu.append('cpu')
    cpu.append(psutil.cpu_percent())
    cpu_times = psutil.cpu_times_percent()
    cpu.append(cpu_times[0])
    cpu.append(cpu_times[1])
    cpu.append(cpu_times[2])
    cpu.append(cpu_times[3])
    cpu.append(psutil.cpu_count())
    return (cpu)
    # output.write(str(cpu))
    # output.write("\n")

#Lets create a function to store performance information from about active memory
def memory():
    #We create our empty list
    # 1 = Memory Total
    # 2 = Memory Available
    # 3 = Memory Percent
    # 4 = Memory Used
    # 5 = Memory Free
    memory = []
    #Now lets parse system performance stats
    virtmem = psutil.virtual_memory()
    memory.append(ts)
    memory.append('memory')
    memory.append(int(virtmem[0]))
    memory.append(int(virtmem[1]))
    memory.append(virtmem[2])
    memory.append(int(virtmem[3]))
    memory.append(int(virtmem[4]))
    # output.write(str(memory))
    # output.write("\n")
    return (memory)

#Lets create a function to store performance information from about swap
def swap():
    #We create our empty list
    # 1 = Swap Total
    # 2 = Swap Used
    # 3 = Swap Free
    # 4 = Swap Percent
    swap = []
    #Now lets parse system performance stats
    swapmem = psutil.swap_memory()
    swap.append(ts)
    swap.append('swap')
    swap.append(int(swapmem[0]) / 1024)
    swap.append(int(swapmem[1]) / 1024)
    swap.append(int(swapmem[2]) / 1024)
    swap.append(int(swapmem[3]) / 1024)
    # output.write(str(swap))
    # output.write("\n")
    return (swap)

#Lets create a function to store performance information from about disk
def disk():
    #We create our empty list
    # 1 = Disk Total
    # 2 = Disk Used
    # 3 = Disk Free
    # 4 = Disk Percent
    disk = []
    #Now lets parse system performance stats
    #This current only supports one LV 
    #To Do : Write logic to parse disk stats for unlimited output
    #Add Disk IO counters, these provide a running total, find a way to reset the counter after each parse
    diskstat = psutil.disk_usage('/')
    disk.append(ts)
    disk.append('disk')
    disk.append(int(diskstat[0]) / 1024)
    disk.append(int(diskstat[1]) / 1024)
    disk.append(int(diskstat[2]) / 1024)
    disk.append(int(diskstat[3]) / 1024)
    # output.write(str(disk))
    # output.write("\n")
    return (disk)

########
# MAIN #
########

# print(cpu()[8])
# print(memory())
# print(swap())
# print(disk())

#We are going to close and reopen our file readonly for safe shipping
# output.close()
# output = open(log, 'r')
# out = output.read()
# output.close()
# print(out)
# os.remove(log)




# importing the requests library
import requests
import json
 
# defining the api-endpoint 
API_ENDPOINT = "http://127.0.0.1:8080/metrics"
 
# your API key here
#API_KEY = "XXXXXXXXXXXXXXXXX"
 
# your source code here
# source_code = '''
# print("Hello, world!")
# a = 1
# b = 2
# print(a + b)
# '''
 
# # data to be sent to api
data = {'time':cpu()[0],
        'name':cpu()[1],
        'metrics':[cpu()[2],cpu()[3],cpu()[4],cpu()[5],cpu()[6],cpu()[7]]}

headers = {'Content-type': 'application/json'}
 
# sending post request and saving response as response object
r = requests.post(url = API_ENDPOINT, data = json.dumps(data), headers = headers)
 
# extracting the status code
print(r.status_code)
print(r.text)

# # data to be sent to api
data1 = {'time':memory()[0],
        'name':memory()[1],
        'metrics':[memory()[2],memory()[3],memory()[4],memory()[5]]}

headers1 = {'Content-type': 'application/json'}
 
# sending post request and saving response as response object
r1 = requests.post(url = API_ENDPOINT, data = json.dumps(data1), headers = headers1)
 
# extracting the status code
print(r1.status_code)
print(r1.text)