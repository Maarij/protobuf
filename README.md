# Protobuf Implementations 

This project explores using the protobuf protocol over json for high performance inter-service communication.
# Protocol Buffers
* Interface description language for API
* Platform & language neutral for serializing/deserializing structured data optimized for interservice communication
* Provides client libraries automatically for most used BE languages
* Proto types existing that correspond to exiting common types (int, string, boolean, etc). These contain default values.
* OneOf type is similar to interface implementations
* 1-15 used for most used fields
* Must exercise caution for altering field ordering and type setups

# Introduction & Unary RPC
* Service is defined using a proto
* Calls can be sync or async by a client app
* 4 types of RPC
  * Unary - traditional, 1 request, 1 response
  * Server-streaming - make a request, stream a response back to client
  * Client-streaming - multiple chunks from client (e.g.: file upload)
  * Bidirectional-streaming - Completely independent for number of responses sent and returned
* service paired with rpc keyword helps create client libraries from .proto files that others can consume
* StreamObserver sends the response back through 2 channels: data and error
* Channels are used to communicating with server


