1. keytool -genkeypair -alias jwt -keyalg RSA -dname "CN=jwt, L=Hamburg, S=Hamburg, C=DE" -keypass microservice -storepass microservice
--> 
C:/Hermann Woock/.keystore

2. keytool -list -rfc | openssl x509 -inform pem -pubkey
-->
-----BEGIN PUBLIC KEY-----
MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnKy1J5dK2WRXxRmuZIXN
6WrRJs8eNFnmYU9Q74F2t6q5aScIJuF2ZXIc2Z8GC2R254wg2v9U0TBNXO1/OqHN
+YxSdFv+7Jf3DBi2u9mYJigkPRAcJTyjJDyXzfj02Bv4Y4HLljX1TZzXx6Vc7xpT
pHlP3K/BLjGMxyhow/SvJq0/SR7MlBOTzIP4YPuv+VACF1Etffr94hreSTAf5iBK
McXZng8koXYloS4D40W1CqSimFnO9KuaqUIU83tsGayNEMqlEzk07E94dQyALm5+
xN+9Axl/0Nhpr4PEem/Rdp896Emr0INWg90V8RV6lWgwzw/oIJ4tR7PMBeP9ViVr
gQIDAQAB
-----END PUBLIC KEY-----
-----BEGIN CERTIFICATE-----
MIIDHTCCAgWgAwIBAgIEHKeVRTANBgkqhkiG9w0BAQsFADA/MQswCQYDVQQGEwJE
RTEQMA4GA1UECBMHSGFtYnVyZzEQMA4GA1UEBxMHSGFtYnVyZzEMMAoGA1UEAxMD
and0MB4XDTE3MDQyNDA4MzIzNVoXDTE3MDcyMzA4MzIzNVowPzELMAkGA1UEBhMC
REUxEDAOBgNVBAgTB0hhbWJ1cmcxEDAOBgNVBAcTB0hhbWJ1cmcxDDAKBgNVBAMT
A2p3dDCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAJystSeXStlkV8UZ
rmSFzelq0SbPHjRZ5mFPUO+BdrequWknCCbhdmVyHNmfBgtkdueMINr/VNEwTVzt
fzqhzfmMUnRb/uyX9wwYtrvZmCYoJD0QHCU8oyQ8l8349Ngb+GOBy5Y19U2c18el
XO8aU6R5T9yvwS4xjMcoaMP0ryatP0kezJQTk8yD+GD7r/lQAhdRLX36/eIa3kkw
H+YgSjHF2Z4PJKF2JaEuA+NFtQqkophZzvSrmqlCFPN7bBmsjRDKpRM5NOxPeHUM
gC5ufsTfvQMZf9DYaa+DxHpv0XafPehJq9CDVoPdFfEVepVoMM8P6CCeLUezzAXj
/VYla4ECAwEAAaMhMB8wHQYDVR0OBBYEFLLpR/0XZdRhFVYijoWIBWWgekDZMA0G
CSqGSIb3DQEBCwUAA4IBAQBFiEDgr4s8fHKIKYdNZnbV/wcY7LkRdt+V/dj/DcOb
Mslg43Kygb3iaEAoQ0snSu6pBE3hJ7IpTBmzHeN8Crx9T1w7j22tMAoJ3AWp0Tg6
jCtob3sXQYhwYa3v8o8/BlyWhwQpJydsM1D8l0LL5x9suCQ98GrO/zVPx9GNnrtT
OzUOcL6vwsDbNOQmuKpC8XzlteZC4f7icmk/jc9lHGKpWGTV9QirM7XoTmOK1xV9
cN40Tj7cg3yPJMe1JoavPMh0DoL0B6P2hXMaRR/u8B549Wzy9rhtIwiSCAZ3L8/V
Dx0lnQcyW4Y+hjDxkHC146cAEl1VJN5vY1HWc+u1Zv4S
-----END CERTIFICATE-----

3. http://localhost:9999/oauth/token?grant_type=password&username=reader&password=reader
-->
{
"access_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE0OTMwODI0MTYsInVzZXJfbmFtZSI6InJlYWRlciIsImF1dGhvcml0aWVzIjpbIkZPT19SRUFEIl0sImp0aSI6Ijg0ZWIxZWQwLWNjNWItNGYyOS1iOGVlLTk4OTU3MmNkNjFiNCIsImNsaWVudF9pZCI6IndlYl9hcHAiLCJzY29wZSI6WyJGT08iXX0.isHETgl9a-dFv6kYaoqAcCqXyClsuD6xxs_fqBr6xspbp8hcrMH15nVTz5DE7u3XvYrpYJTso6bRTJnAsgRqeXcYR4YLk1WyBPtG4QJwQAF0JErkPuWkWWp5bQJynpvWKgDvpCIsDgKr4M5qmfhKWsjF1yGz2hA02U4jlJaQZ4ooW6ClRVFxgyBZEoIBzrDzC_SUtMyk4hO0-QFP1OzxVIypalxL8CZvMWY3XsoZaB9HkuK6_v0gprxSN1zzKJh19qbR3qfgyZ7Z9t7Gpon8syLw9kc265qsVt6AdVpmH1L-eZF2-ymblVWZLwilUD5mYVBQ2c24oT9QFP8RpZbwYA",
"token_type": "bearer",
"refresh_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJyZWFkZXIiLCJzY29wZSI6WyJGT08iXSwiYXRpIjoiODRlYjFlZDAtY2M1Yi00ZjI5LWI4ZWUtOTg5NTcyY2Q2MWI0IiwiZXhwIjoxNDk1NjMxMjE2LCJhdXRob3JpdGllcyI6WyJGT09fUkVBRCJdLCJqdGkiOiJkNmI5NjliNi04YTM0LTQxODgtYTg0Yy0xNGQyODllMGUxNjAiLCJjbGllbnRfaWQiOiJ3ZWJfYXBwIn0.Ol-JmYxPQN80XjNsYbokXlfpkLI_tUUTIGnNJ4R87XUQQThpPx37VcIrS0qUcZrVXZ9x_x7hwdKwSgRBwaQ8CX_0JozFJ2EP3iDsMgc7LJjmZrcM9ElJ-XbYFJBM8Q8sE_wYVqIWYMPolP6v-QI0a3del_-niEBNU6CEECKoqIuPEnGuGAdIgT-8kDb-y8dgc5i8-RBlsoJhobMqhXZdR1XfRYNydQnmW6oFgMLYvpy8eGTbySCV1z5AJDrXqQ5jYaazk0OMRReKKJY6D5dGuWnmjnXLpcbSkHOMAVOo5T1aJyFFDn9AshLISi0qfP9pKrqu9GfjYoVh3CMJzFibHQ",
"expires_in": 43199,
"scope": "FOO",
"jti": "84eb1ed0-cc5b-4f29-b8ee-989572cd61b4"
}

4. http://localhost:9090/foo header: Authorization: Bearer ey...
--> 
read foo 6ea8111d-5b41-4ce7-a187-34694ab5331f
