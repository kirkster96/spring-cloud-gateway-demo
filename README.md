# Gateway demo
This project demonstates the ability of Spring Cloud gateway.

Suppose you have multiple REST APIs throughout the network in your organization.

It would be nice if a website GUI was capable of accessing all the REST APIs.

The Spring Cloud Gateway provides this capability by acting as a reverse proxy for the website it is hosting.

## How does it work?

Start both server applications and the descriptions below explains what is happening in this distributed system.

### _1. gateway-a_
The module **gateway-a** is intended to be started on port 8080 (the default by spring boot).

You can choose any port for **gateway-a**, as long as it is available and you have permission to bind an application
to it.

When you launch the gateway server, you can navigate to its host:port in your web browser to.

For example, open the page http://localhost:8080 if you are hosting the server application locally.

Or you may put something that looks like the following:
- http://0.0.0.0:8080
- http://192.168.137.7:8080
- http://my.server.com:8080

It depends on the IP address, port, and domain name (if any) of the system you are hosting this app on.

### _2. test-endpoint-a_

The module **test-endpoint-a** is intended to be started on `port 8081`.

The configuration I used was to host this app on http://localhost:8081

This is reflected in the application.yaml of `./test-endpoint-a/src/main/resources/application.yaml`

```yaml
server:
  port: 8081
```

You can change
- The port of test-endpoint-a
- The host of test-endpoint-a (i.e. put it on a different system with a different IP address)

**AS LONG AS** you update the `./gateway-a/src/main/resources/application.yaml` to reflect the configuration you create.

The gateway-a module must know the uri of the remote service it is integrating with.

## Why is this helpful

In my opinion, configuring CORS to allow a website to access two different REST APIs is a huge pain. Imagine creating
a website that requires CORS configuration, most individuals cannot make this configuration themselves and most IT
departments at organizations will dislike having to configure this capability.

It is much easier have a server application act as a reverse proxy for the website. In other words, the website will talk to the gateway
and the gateway will route requests to the correct REST APIs on the website's behalf.

This example only shows 1 REST API connected with the gateway, but you can easily add as many REST APIs as you want!
