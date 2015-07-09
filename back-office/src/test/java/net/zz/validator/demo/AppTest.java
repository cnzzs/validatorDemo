package net.zz.validator.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by ZaoSheng on 2015/6/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
@ContextConfiguration(locations ="classpath:test_applicationContext.xml")
public class AppTest {
//    private MockMvc mockMvc;

   /* @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;*/

  /*  @Before
   public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }*/

   /* @Test
    public void simple() throws Exception {
        mockMvc.perform(get("/api/member/isQQExist"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"));
    }*/

    @Valid
    public void val(@NotNull(message = "aaaa") String aa)
    {
        System.out.println("aaa");
    }

    @Test
    public void test()
    {
        val(null);
    }

}
