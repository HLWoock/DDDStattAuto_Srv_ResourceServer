package de.woock.ddd.stattauto.resourceserver;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertTrue;

import java.util.Collections;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.Signer;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DddStattAutoSrvResourceServerApplicationTests {
	
	@Test
	public void roundTripCustomHeaders() throws Exception {
		Signer hmac = null;
		CharSequence JWT = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9."
				         + "eyJleHAiOjE0OTMwODI0MTYsInVzZXJfbmFtZSI6InJlYWRlciIsImF1dGhvcml0aWVzIjpbIkZPT19SRUFEIl0sImp0aSI6Ijg0ZWIxZWQwLWNjNWItNGYyOS1iOGVlLTk4OTU3MmNkNjFiNCIsImNsaWVudF9pZCI6IndlYl9hcHAiLCJzY29wZSI6WyJGT08iXX0."
				         + "isHETgl9a-dFv6kYaoqAcCqXyClsuD6xxs_fqBr6xspbp8hcrMH15nVTz5DE7u3XvYrpYJTso6bRTJnAsgRqeXcYR4YLk1WyBPtG4QJwQAF0JErkPuWkWWp5bQJynpvWKgDvpCIsDgKr4M5qmfhKWsjF1yGz2hA02U4jlJaQZ4ooW6ClRVFxgyBZEoIBzrDzC_SUtMyk4hO0-QFP1OzxVIypalxL8CZvMWY3XsoZaB9HkuK6_v0gprxSN1zzKJh19qbR3qfgyZ7Z9t7Gpon8syLw9kc265qsVt6AdVpmH1L-eZF2-ymblVWZLwilUD5mYVBQ2c24oT9QFP8RpZbwYA";
		Jwt token = JwtHelper.decode(JwtHelper.encode(JWT, hmac, Collections.singletonMap("foo", "bar")).getEncoded());
		assertTrue("Wrong header: " + token, token.toString().contains("\"foo\":\"bar\""));
	}

	@Test
	@Ignore
	public void roundTripClaims() throws Exception {
		Signer hmac = null;
		CharSequence JOE_CLAIM_SEGMENT = null;
		Jwt token = JwtHelper.decode(JwtHelper.encode(JOE_CLAIM_SEGMENT, hmac).getEncoded());
		assertTrue("Wrong header: " + token, token.toString().contains("\"alg\":\"HS256\",\"typ\":\"JWT\""));
	}


	@Test
	public void TestOAuthService() {
		
		ResourceOwnerPasswordResourceDetails resource = new ResourceOwnerPasswordResourceDetails();
		resource.setUsername("reader");     
		resource.setPassword("reader");    
		resource.setAccessTokenUri("http://localhost:9999/oauth/token");
		resource.setClientId("web_app");
		resource.setClientSecret("");
		resource.setGrantType("password");
		resource.setScope(asList("FOO"));		
//		OAuth2SecurityContextHolder.getContext().getAccessTokens()
		
		OAuth2RestTemplate         restTemplate  = new OAuth2RestTemplate(resource, new DefaultOAuth2ClientContext());
		String                     message       = restTemplate.getForObject("http://localhost:9090/foo", String.class);
		
		System.out.println(message);
		assertTrue( message.startsWith("read foo"));
	}

}
