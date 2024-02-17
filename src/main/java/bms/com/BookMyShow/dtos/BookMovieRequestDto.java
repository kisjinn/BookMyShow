package bms.com.BookMyShow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class BookMovieRequestDto {
    private Long userId;
    private Long showId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public List<Long> getShowSeatIds() {
        return showSeatIds;
    }

    public void setShowSeatIds(List<Long> showSeatIds) {
        this.showSeatIds = showSeatIds;
    }

    private List<Long> showSeatIds;
}
