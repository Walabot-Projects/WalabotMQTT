## WalabotMQTT - Android Application
Java MQTT client and abstract activity which enables easy start for creating a Walabot Android Application.
<p align="center">
  <img src="https://i.imgur.com/jIqzLYf.gif">
</p>
**Prerequisites**
* Install Android Studio
* For Android beginners, you may start with: [Create an Android project](https://developer.android.com/training/basics/firstapp/creating-project)
* Create an MQTT broker and a Walabot publisher : See the main page and twin directory _WalabotMQTT- python publisher_

**Enable MQTT on Your Application**
* Dependencies: add the following line to your build.gradle.
    ```
    dependencies {
        implementation 'org.eclipse.paho:org.eclipse.paho.client.mqttv3:1.1.1'
        implementation 'org.eclipse.paho:org.eclipse.paho.android.service:1.1.1'
    }
    ```
* Permissions: add the following lines to your AndroidManifest.xml file before the opening `application` tag
    ```
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.WAKE_LOCK" />
    ```
* MQTT Service: another line to add to your AndroidManifest.xml file, before the closing `application` tag 
    ```
   <service android:name="org.eclipse.paho.android.service.MqttService" />
    ```

**How To Use**
1. Place the files "WalabotApp.java" and "WalabotClient.java" in your app package.
2. Your app's activities should inherit from the abstract class "WalabotApp" (which extends AppCompatActivity).
3. Implement getters:
    - For establish the connection with the broker
        ```java
        abstract public String getBrokerIpAddress();
        abstract public int getBrokerPort();
        abstract public String getBrokerUserName();
        abstract public String getBrokerPassword();
        ```
    - Unique connection id (shared with the Walabot publisher).
        ```java
        abstract public String getConnectionId();
        ```
4. Communication with Walabot:
    -  Send a message to start/stop recording
        ```java
        public void startWalabot()
        public void stopWalabot()
        ```
    - Receiving data (should be parsed as a JSON Object)
    ```java
    abstract public void onDataReceived(final String message);
    ```
For a closer view on the app flow you may look at the example-app.    

