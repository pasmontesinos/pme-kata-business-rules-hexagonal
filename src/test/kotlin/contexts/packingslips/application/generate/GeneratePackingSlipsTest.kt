package contexts.packingslips.application.generate

import contexts.packingslips.domain.PackingSlipMother
import io.mockk.mockk
import io.mockk.verify
import mo.staff.contexts.packingslips.application.generate.GeneratePackingSlips
import mo.staff.contexts.packingslips.application.generate.GeneratePackingSlipsCommand
import mo.staff.contexts.packingslips.domain.PackingSlip
import mo.staff.contexts.packingslips.domain.PackingSlipRepository
import mo.staff.contexts.shared.domain.Id
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


class GeneratePackingSlipsTest  {

    private lateinit var packingSlipRepository: PackingSlipRepository
    private lateinit var generatePackingSlips: GeneratePackingSlips

    @BeforeEach
    fun setUp() {
        packingSlipRepository = mockk<PackingSlipRepository>(relaxed = true)
        generatePackingSlips = GeneratePackingSlips(packingSlipRepository)
    }

    @Test
    fun `should generate shipping packing slip for physical products`() {
        val command = GeneratePackingSlipsCommand(ORDER_ID, PHYSICAL_PRODUCT_IDS, listOf())

        generatePackingSlips.execute(command)

        verify {
            packingSlipRepository.save( match {
                it.orderId == ORDER_ID &&
                it.type == PackingSlip.Type.SHIPPING &&
                it.productIds == PHYSICAL_PRODUCT_IDS
            })
        }
    }

    companion object {
        private val ORDER_ID = Id.random().toString()
        private val PHYSICAL_PRODUCT_IDS = listOf(
            Id.random().toString(),
            Id.random().toString()
        )
    }
}