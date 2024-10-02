# SNG Crest device service web
This service processes firmware files for the standard notifying gateway and posts the firmware via REST.

## Developer configuration
To retrieve GXF dependencies you need to configure a local GitHub token.

1. Go to GitHub to create a classic token: [Create Classic Token](https://github.com/settings/tokens/new)
2. Give the token a name
3. Choose an appropriate expiration date 
4. Add the scope `read:packages`
5. Press the `Generate token` button
6. Copy the newly generated token

Now place the generated token in `~/.gradle/gradle.properties` 
```properties
github.username=<github username>
github.token=<github token>
```
 
