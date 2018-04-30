# WalabotMQTT-python publisher

Python framework for establishing walabot data publisher using MQTT protocol.

Using this code structure the Walabot can collect and process data on a remote device (ie. Raspberry Pi),
and publish it under a common topic with the apps (the subscribers).

### Required Python(3.5<) Libraries

* WalabotAPI
* paho-mqtt

### Create MQTT broker

* Cloud broker: can be created on [cloudMQTT](https://api.cloudmqtt.com) \
 see [MQTT Android Client Tutorial](https://wildanmsyah.wordpress.com/2017/05/11/mqtt-android-client-tutorial/) for further instructions.
* Local broker: for running on your own device, follow the instructions at: [How to Install The Mosquitto](http://www.steves-internet-guide.com/install-mosquitto-broker/)


### How to use

1. Install the [Walabot SDK](http://walabot.com/getting-started) and the WalabotAPI Python library using pip.
2. Install paho-mqtt `pip install paho-mqtt`
3. Your app should inherit from WalabotHandler and implement the following methods:
- start - Sets walabot configurations ant start recording.\
            Returns: True/ False on success/ failure
- get_data - Fills a given data dictionary\
            Returns: True/ False on success/ failure
- Defines broker connection properties: ip address, port, username and password.
- Defines unique conection_id (shared with the walabot app).
  This id will define the communication topic between the publisher and the subscriber app.

### Code flow
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

### Running the Publisher
```python
if __name__ == '__main__':
    mqtt = WalabotMQTT(MyWalabotHandnler)
```

Some examples can be found at breathing_handler/ targets_handler.
