# WDForward
Simple plugin for forwarding data through the Plugin Messaging Channel to other downstream servers


# How to use
## Sending
You send a PluginMessage to the Server following this pattern: <br/>
tag/eventName: "forward"
content: 
- targetServer: string (writeUTF)
- payloadLength: signed Integer (writeInt)
- payload: bytes (writeFully)


## Receiving
Data will be received using the "forward" tag. After that, you can read and interpret the payload you sent before.
