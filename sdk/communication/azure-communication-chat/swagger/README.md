# Azure Communication Service - Chat SDK for Android

> see https://aka.ms/autorest

### Setup
```ps
Fork and clone https://github.com/Azure/autorest.java 
git checkout android-v4
git submodule update --init --recursive
mvn package -Dlocal
npm install
npm install -g autorest
```

### Generation
```ps
cd <swagger-folder>
autorest --android --use=C:/work/autorest.java
```

### Code generation settings
``` yaml
input-file: https://raw.githubusercontent.com/Azure/azure-rest-api-specs/838c5092f11e8ca26e262b1f1099d5c5cdfedc3f/specification/communication/data-plane/Microsoft.CommunicationServicesChat/preview/2020-09-21-preview2/communicationserviceschat.json
java: true
output-folder: ..\
generate-client-as-impl: false
namespace: com.azure.android.communication.chat
sync-methods: all
license-header: MICROSOFT_MIT_SMALL
add-context-parameter: false
models-subpackage: models
context-client-method-parameter: false
custom-types-subpackage: models
android: true
required-parameter-client-methods: true
generate-sync-async-clients: true
```
