package org.nix.zpbs.utils.verification.image;

import org.apache.catalina.ssi.ByteArrayServletOutputStream;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.nix.zpbs.LoveOAuth2Application;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = LoveOAuth2Application.class)
@RunWith(value = SpringJUnit4ClassRunner.class)
public class ImageVerificationTest {

    @Resource
    private ImageVerification imageVerification;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Before
    public void setUp(){
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
    }

    @Test
    public void createVerification() throws IOException {
        when(request.getSession()).thenReturn(new MockHttpSession());
        when(response.getOutputStream()).thenReturn(new ByteArrayServletOutputStream());
        imageVerification.createVerification(request,response);
    }

    @Test
    public void submitVerification() {
    }
}