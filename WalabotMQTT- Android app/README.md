## WalabotMQTT-Android app
Java MQTT client and abstract activity which enables easy start for creating a walabot Android app.

**Before Starting**
* For beginners (like me), you may star from: [Create an Android project](https://developer.android.com/training/basics/firstapp/creating-project)
* Create MQTT broker and walabot publisher : See the main page and twin directory _WalabotMQTT- python publisher_

**Enable MQTT on your app**
* Dependecies: add the following line in your build.gradle of your Android app.
    ```
    dependencies {
        implementation 'org.eclipse.paho:org.eclipse.paho.client.mqttv3:1.1.1'
        implementation 'org.eclipse.paho:org.eclipse.paho.android.service:1.1.1'
    }
    ```
* Permissions: add the following lines in your AndroidManifest.xml file before the opening `application` tag
    ```
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.WAKE_LOCK" />
    ```
* MQTT Service: another line to add in your AndroidManifest.xml file, before the closing `application` tag 
    ```
   <service android:name="org.eclipse.paho.android.service.MqttService" />
    ```

**How to use**
1. Place the files "WalabotApp.java" and "WalabotClient.java" in your app package.
2. Your apps activities should inherit from the abstract class "WalabotApp" (which extends AppCompatActivity).
3. Implement getters:
    - For establish the connection with the broker
        ```java
        abstract public String getBrokerIpAddress();
        abstract public int getBrokerPort();
        abstract public String getBrokerUserName();
        abstract public String getBrokerPassword();
        ```
    - Unique Conection id (shared with the walabot publisher).
        ```java
        abstract public String getConnectionId();
        ```
4. Communication with Walabot :
    -  Send a message to start/stop recording
        ```java
        public void startWalabot()
        public void stopWalabot()
        ```
    - Receiving data (shuold be pared as a JSON Object)
    ```java
    abstract public void onDataReceived(final String message);
    ```
For a closer view on the app flow you may look at the example-app.    
<p align="center">
  <img src="https://media.giphy.com/media/yvzXnhKdUugxa0E3vJ/giphy.gif">
</p>
