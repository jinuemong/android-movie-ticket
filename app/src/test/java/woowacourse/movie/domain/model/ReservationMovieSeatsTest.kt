package woowacourse.movie.domain.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import woowacourse.movie.presentation.seat.model.SeatSelectType

class ReservationMovieSeatsTest {
    @Test
    fun `getSeatPrice_메서드가_올바른_가격을_반환하는지_확인한다`() {
        // Given
        val seatA = MovieSeat("A1", SeatType.A)
        val seatB = MovieSeat("B2", SeatType.B)
        val seats = arrayListOf(seatA, seatB)
        val reservationMovieSeats = ReservationMovieSeats(ticketCount = 5)
        reservationMovieSeats.userSeats.addAll(seats)

        // When
        val totalPrice = reservationMovieSeats.getSeatPrice()

        // Then
        assertEquals(SeatType.A.price + SeatType.B.price, totalPrice)
    }

    @Test
    fun `setSeatSelectType_메서드가_적절한_SeatSelectType을_설정하는지_확인한다`() {
        // Given
        val reservationMovieSeats = ReservationMovieSeats(ticketCount = 5)
        reservationMovieSeats.userSeats.add(MovieSeat("A1", SeatType.A))

        // When
        reservationMovieSeats.setSeatSelectType(MovieSeat("A1", SeatType.A))

        // Then
        assertEquals(SeatSelectType.REMOVE, reservationMovieSeats.seatSelectType)
    }

    @Test
    fun `좌석을_선택하면_선택된_좌석_리스트에_추가된다`() {
        // Given
        val reservationMovieSeats = ReservationMovieSeats(ticketCount = 5)
        val seat = MovieSeat("A1", SeatType.A)

        // When
        reservationMovieSeats.addSeat(seat)

        // Then
        assertEquals(1, reservationMovieSeats.userSeats.size)
        assertEquals(seat, reservationMovieSeats.userSeats.first())
    }

    @Test
    fun `선택된_좌석을_재선택하면_선택이_해제된다`() {
        // Given
        val seatA = MovieSeat("A1", SeatType.A)
        val seatB = MovieSeat("B2", SeatType.B)
        val seats = arrayListOf(seatA, seatB)
        val reservationMovieSeats = ReservationMovieSeats(ticketCount = 5)
        reservationMovieSeats.userSeats.addAll(seats)

        // When
        reservationMovieSeats.deleteSeat(seatA)

        // Then
        assertEquals(1, reservationMovieSeats.userSeats.size)
        assertEquals(seatB, reservationMovieSeats.userSeats.first())
    }

    @Test
    fun `updateSeatSelectType_메서드가_적절한_SeatSelectType을_설정하는지_확인한다`() {
        // Given
        val reservationMovieSeats = ReservationMovieSeats(ticketCount = 5)
        reservationMovieSeats.userSeats.addAll(listOf(MovieSeat("A1", SeatType.A), MovieSeat("B2", SeatType.B)))

        // When
        reservationMovieSeats.updateSeatSelectType()

        // Then
        assertEquals(SeatSelectType.ADD, reservationMovieSeats.seatSelectType)
    }
}
