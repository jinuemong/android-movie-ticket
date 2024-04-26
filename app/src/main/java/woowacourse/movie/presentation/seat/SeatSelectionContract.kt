package woowacourse.movie.presentation.seat

import woowacourse.movie.domain.model.MovieSeat
import woowacourse.movie.presentation.model.TicketModel
import woowacourse.movie.presentation.seat.model.SeatSelectType

interface SeatSelectionContract {
    interface View {
        fun showTicket(ticketModel: TicketModel)

        fun showSeat(seats: List<List<MovieSeat>>)

        fun showSelectedSeat(
            rowIndex: Int,
            columnIndex: Int,
        )

        fun showUnSelectedSeat(
            rowIndex: Int,
            columnIndex: Int,
        )

        fun showCurrentResultTicketPriceView(seatPrice: Int)

        fun offConfirmAvailableView()

        fun onConfirmAvailableView()

        fun moveToTicketDetail(ticket: TicketModel)

        fun showDialog()
    }

    interface Presenter {
        fun loadTicket()

        fun loadSeat()

        fun selectSeat(
            rowIndex: Int,
            columIndex: Int,
        )

        fun getSeats(): List<MovieSeat>

        fun ticketing()

        fun confirmSeatResult()
    }
}
