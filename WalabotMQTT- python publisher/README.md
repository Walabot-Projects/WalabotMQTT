## WalabotMQTT - Python Publisher

Python framework for establishing Walabot data publisher using the MQTT protocol.

Using this code structure, the Walabot can collect and process data on a remote device (i.e. Raspberry Pi),
and publish it under a common topic with the apps (the subscribers).

**Prerequisites**
* Install the [Walabot SDK](http://walabot.com/getting-started) and the WalabotAPI Python library using pip.
* Install paho-mqtt: `pip install paho-mqtt`
* Create an MQTT broker: See the repo main  page.

**How To Use**

Your app should inherit from _WalabotHandler_ and implement the following methods:
1. start - Sets Walabot configurations and starts recording.\
            Returns: True/False on success/failure
2. get_data - Fills a given data dictionary\
             this data will be sent as a JSON String\
             Returns: True/False on success/failure
3. Defines broker connection properties: ip address, port, username and password.
4. Defines unique conection_id (shared with the walabot app).
  This id will define the communication topic between the publisher and the subscriber app.

<br>

**Code flow**
```python
from walabot_handler import WalabotHandler
from walabot_mqtt_publisher import WalabotMQTT

class MyWalabotHandnler(WalabotHandler):

    connection_id = 'unique_app'
    broker_ip_address = "cloudmqtt.com"
    broker_port = 1234
    broker_username = 'user'
    broker_password = 'pass'
    
    def __init__(self):
        super(BreathingHandler, self).__init__()
     
    def start(self):
        .configurations
        .
        .
       self._wlbt.Start()
       return True/False
       
    def get_data(self, data_dict):
        self._wlbt.Trigger()
        data_dict['important inforamtion'] = 123
        return True/False
    
    def stop(self):
        self._wlbt.Stop()
        self._wlbt.Disconnect()
        self._wlbt.Clean()        
```

**Running the Publisher**
```python
if __name__ == '__main__':
    mqtt = WalabotMQTT(MyWalabotHandnler)
```

Some examples can be found at breathing_handler/ targets_handler.
