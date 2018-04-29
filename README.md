# WalabotMQTT-Publisher

Python framework for establishing walabot data publisher using MQTT protocol.

Using this code structure the Walabot can collect data on a remote device (ie. Raspberry Pi), with the processing taking place on another machine.

### Required Python(3.5<) Libraries

* WalabotAPI
* paho-mqtt

### Create MQTT broker

* Cloud broker: for example [cloudMQTT](https://api.cloudmqtt.com) \
 look at [MQTT Android Client Tutorial](https://wildanmsyah.wordpress.com/2017/05/11/mqtt-android-client-tutorial/) for further instructions.
* Local broker: for running on your own device, follow the instructions at: [How to Install The Mosquitto](http://www.steves-internet-guide.com/install-mosquitto-broker/)


## How to use

1. Install the [Walabot SDK](http://walabot.com/getting-started) and the WalabotAPI Python library using pip.
2. Install paho-mqtt `pip install paho-mqtt`
3. Your app should inherit from WalabotHandler and implement the following methods:
- start - Sets walabot configurations ant start recording.\
            Returns: True/ False on success/ failure
- get_data - Fills a given data dictionary\
            Returns: True/ False on success/ failure
- Defines broker connection properties: ip address, port, username and password.
- Defines unique conection_id which will define the shared topic with the app.

 

### Running the Publisher
```python
from walabot_app import YourApp as WalabotHandler
from walabot_mqtt_publisher import WalabotMQTT

if __name__ == '__main__':
    mqtt = WalabotMQTT(WalabotHandler)
```

See breating_handler as WalabotHandler example.


   
