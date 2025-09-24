package dev.umang.bookmyshow_17_09_2025.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


public class BookingRequestDTO {
    private Long userId;
    private List<Long> showSeatsIds;
    private Long showId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getShowSeatsIds() {
        return showSeatsIds;
    }

    public void setShowSeatsIds(List<Long> showSeatsIds) {
        this.showSeatsIds = showSeatsIds;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }
}
