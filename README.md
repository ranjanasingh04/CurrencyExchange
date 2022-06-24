# CurrencyExchange
Currency Exchange Value Calculation

# Installation

## Build

The CurrencyExchange is build using maven.

### Building options

More building options are provided using maven profiles.

### How to Use a Web Service
For “RESTful” web services, you send an ordinary HTTP request message with query parameters for the information you want (some services also use HTTP header fields or the request body). The URL identifies the service that you want. Here are two examples:

CurrencyLayer.com Live Exchange Rate service: http://apilayer.net/api/live?query_params
Some web services are free to everyone, even without registering. But most web services require you to register first and receive an API Key. The API Key is a string that you include with every web service request. You send your API Key as a query parameter or as part of an HTTP Header field (varies depending on the service).

###
Develop a currency exchange web application using a public currency converter API (e.g. https://api.apilayer.com/ Free API). The application have a main page to query  current exchange rates.

Entered number and from/to currency from dropdown and button to calculate the value.