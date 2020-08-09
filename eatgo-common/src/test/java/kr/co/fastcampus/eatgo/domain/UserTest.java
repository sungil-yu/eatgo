package kr.co.fastcampus.eatgo.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class UserTest {

    @Test
    public void creation(){

        User user = User.builder()
                .email("tester@example.com")
                .name("테스터")
                .level(100L)
                .build();

        assertThat(user.getName()).isEqualTo("테스터");
        assertThat(user.isAdmin()).isTrue();
        assertThat(user.isActive()).isTrue();

        user.deactive();
        assertThat(user.isActive()).isFalse();
    }

    @Test
    public void accessTokenWithPassword(){
        User user = User.builder()
                .password("ACCESSTOKEN").build();

        assertThat(user.getAccessToken()).isEqualTo("ACCESSTOKE");

    }


    @Test
    public void accessTokenWithoutPassword(){
        User user = new User();

        assertThat(user.getAccessToken()).isEqualTo("");

    }
}