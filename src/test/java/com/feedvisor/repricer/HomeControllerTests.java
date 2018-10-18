package com.feedvisor.repricer;

import com.feedvisor.repricer.config.AppProperties;
import com.feedvisor.repricer.controllers.HomeController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeControllerTests {

  @InjectMocks
  private HomeController hc;

  @Mock
  private AppProperties appProperties;

  @Before
  public void init(){
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testHomeController() {
    when(appProperties.getApiVersion()).thenReturn("1.0.0");
    String result=hc.getAppVersion();

    verify(appProperties).getApiVersion();

    assertThat(result,is("1.0.0"));
  }
}
