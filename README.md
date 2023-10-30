# Protobuf Implementations

https://www.udemy.com/course/grpc-the-complete-guide-for-java-developers 

This project explores using the protobuf protocol over json for high performance inter-service communication.

# Protocol Buffers
* Interface description language for API
* Platform & language neutral for serializing/deserializing structured data optimized for interservice communication via HTTP/2 for transport
* Provides client libraries automatically for most used BE languages
* Proto types existing that correspond to exiting common types (int, string, boolean, etc). These contain default values.
* OneOf type is similar to interface implementations
* 1-15 used for most used fields
* Must exercise caution for altering field ordering and type setups

# Introduction & Unary RPC
* Client makes a single request and server sends a single response
* Service is defined using a proto
* Calls can be sync or async by a client app
* 4 types of RPC
  * Unary - traditional, 1 request, 1 response
  * Server-streaming - make a request, stream a response back to client
  * Client-streaming - multiple chunks from client (e.g.: file upload)
  * Bidirectional-streaming - Completely independent for number of responses sent and returned
* service paired with rpc keyword helps create client libraries from .proto files that others can consume
* StreamObserver sends the response back through 2 channels: data and error
* Channels are used to communicating with server's port

# Server Streaming RPC
* Client makes a single request and server can send a stream of responses
* Status response codes: https://developers.google.com/actions-center/reference/grpc-api-v2/status_codes
* Use case is when you need to provide multiple responses over time or not overwhelm the receiver

# Client Streaming RPC
* Client streams requests and server sends a single response
* Client invokes method and is returned a handler for streaming

# Bi-Directional Streaming RPC
* Client streams multiple requests and server streams responses back for each request

# Load Balancing
* HTTP/1 works by sending a request and waiting for a response. Until you get a response, you cannot make another request in the same connection
* HTTP/2 overcomes this by multiplexing. You can send multiple and parallel requests via one connection
* Configurable channels are created allow the HTTP/2 channel to persist
  * Channel establishes a connection if one does not exist between client and server
  * Thread-safe but expensive process to create initially
  * Shared between multiple stubs for the server
* Server side and client side load balancing available
* Server side places a proxy in front, client unaware through channel
* Client side does not using a proxy to be faster
 * This requires the client knowing all the server IPs via a server registry and sub-channels
 
# Deadlines
* Issues can occur where the client is still waiting for a request but kills the connection.
* Deadlines can be used by the client to do this but this can cause the server to continue processing
* Server calls should check if the call is canceled

# Interceptor
* Can intercept RPCs both at client and server side. Useful for cross-cutting concerns.

