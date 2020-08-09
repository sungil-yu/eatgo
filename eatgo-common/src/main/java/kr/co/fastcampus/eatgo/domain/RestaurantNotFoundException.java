package kr.co.fastcampus.eatgo.domain;

public class RestaurantNotFoundException extends RuntimeException {

    public RestaurantNotFoundException(Long id) {
        super("Could Not Find Restaurant" + id);
    }
}
