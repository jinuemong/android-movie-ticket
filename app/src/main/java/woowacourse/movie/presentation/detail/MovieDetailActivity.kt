package woowacourse.movie.presentation.detail

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import woowacourse.movie.R
import woowacourse.movie.domain.model.Ticket
import woowacourse.movie.presentation.reservation.MovieReservationPresenter
import woowacourse.movie.presentation.reservation.model.TicketModel

class MovieDetailActivity : AppCompatActivity() {
    private lateinit var ticketTitle: TextView
    private lateinit var ticketScreeningDate: TextView
    private lateinit var ticketPrice: TextView
    private lateinit var ticketCount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_reservation_complete)
        initView()
        setTicketData()
    }

    private fun initView() {
        ticketTitle = findViewById(R.id.ticket_title)
        ticketScreeningDate = findViewById(R.id.ticket_screening_date)
        ticketPrice = findViewById(R.id.ticket_price)
        ticketCount = findViewById(R.id.ticket_number_of_people)
    }

    private fun setTicketData() {
        makeTicket()?.let { ticket ->
            ticketTitle.text = ticket.title
            ticketScreeningDate.text = ticket.screeningDate
            ticketPrice.text = String.format(TICKET_PRICE, ticket.price)
            ticketCount.text = TICKET_COUNT.format(ticket.count)
        }
    }

    private fun makeTicket(): TicketModel? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra(MovieReservationPresenter.KEY_NAME_TICKET, TicketModel::class.java)
        } else {
            intent.getSerializableExtra(MovieReservationPresenter.KEY_NAME_TICKET) as? TicketModel
        }
    }

    companion object {
        private const val TICKET_PRICE = "%,d원 (현장결제)"
        private const val TICKET_COUNT = "일반 %d명"
    }
}
