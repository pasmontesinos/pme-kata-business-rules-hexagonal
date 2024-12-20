package app.packingslips

import io.mockk.mockk
import io.mockk.verify
import mo.staff.app.packingslips.GeneratePackingSlipsOnOrderPaid
import mo.staff.contexts.packingslips.application.generate.GeneratePackingSlips
import mo.staff.contexts.packingslips.application.generate.GeneratePackingSlipsCommand
import mo.staff.contexts.shared.domain.Id
import mo.staff.mo.staff.app.packingslips.PackingSlipsOrderPaid
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GeneratePackingSlipsOnOrderPaidTest {

    private lateinit var generatePackingSlips: GeneratePackingSlips
    private lateinit var generatePackingSlipsOnOrderPaid: GeneratePackingSlipsOnOrderPaid

    @BeforeEach
    fun setUp() {
        generatePackingSlips = mockk<GeneratePackingSlips>(relaxed = true)
        generatePackingSlipsOnOrderPaid = GeneratePackingSlipsOnOrderPaid(generatePackingSlips)
    }

    @Test
    fun `should call generate packing slips with physical products`() {
        val orderPaid = PackingSlipsOrderPaid(ORDER_ID, physicalProducts = PHYSICAL_PRODUCT_IDS)

        generatePackingSlipsOnOrderPaid.handle(orderPaid)

        verify(exactly = 1) {
            generatePackingSlips.execute(
                match<GeneratePackingSlipsCommand> {
                    it.orderId == ORDER_ID &&
                        it.physicalProducts == PHYSICAL_PRODUCT_IDS
                },
            )
        }
    }

    @Test
    fun `should call generate packing slips with book products`() {
        val orderPaid = PackingSlipsOrderPaid(ORDER_ID, bookProducts = BOOK_PRODUCT_IDS)

        generatePackingSlipsOnOrderPaid.handle(orderPaid)

        verify(exactly = 1) {
            generatePackingSlips.execute(
                match<GeneratePackingSlipsCommand> {
                    it.orderId == ORDER_ID &&
                        it.bookProducts == BOOK_PRODUCT_IDS
                },
            )
        }
    }

    companion object {
        private val ORDER_ID = Id.random().toString()
        private val PHYSICAL_PRODUCT_IDS = listOf(Id.random().toString())
        private val BOOK_PRODUCT_IDS = listOf(Id.random().toString())
    }
}
