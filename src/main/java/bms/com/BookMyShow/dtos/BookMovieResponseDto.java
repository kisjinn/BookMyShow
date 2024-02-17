package bms.com.BookMyShow.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookMovieResponseDto {
    private Long bookingID;
    private ResponseStatus responseStatus;
}
