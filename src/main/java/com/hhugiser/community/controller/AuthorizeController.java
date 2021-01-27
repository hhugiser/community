package com.hhugiser.community.controller;

import com.hhugiser.community.dto.AccessTokenDTO;
import com.hhugiser.community.dto.GithubUser;
import com.hhugiser.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @PROJECT_NAME: community
 * @DESCRIPTION:
 * @USER: huxun
 * @DATE: 2020/12/29 15:59
 */
@Controller
public class AuthorizeController {

  @Autowired
  private GithubProvider githubProvider;

  @GetMapping("/callback")
  public String callback(@RequestParam(name = "code") String code,
                         @RequestParam(name = "state") String state) {
    AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
    accessTokenDTO.setCode(code);
    accessTokenDTO.setState(state);
    accessTokenDTO.setClient_id("7697a44b0a6680bd50b7");
    accessTokenDTO.setRedirect_uri("http://localhost:8887/callback");
    accessTokenDTO.setClient_secret("2b105fd1cd7540b61f17a8c1cf56ef9d5a4356e8");
    String accessToken = githubProvider.getAccessToken(accessTokenDTO);
    GithubUser user = githubProvider.getUser(accessToken);
    System.out.println(user.getName());
    return "index";
  }
}
