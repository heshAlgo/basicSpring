package develop.basicSpring.order

import develop.basicSpring.member.Grade
import develop.basicSpring.member.model.Member
import develop.basicSpring.member.serviceImpl.MemberServiceImpl
import develop.basicSpring.order.serviceImpl.OrderServiceImpl
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

/**
 * @author Rasung Ki
 */
class OrderServiceTest {
    private val memberService = MemberServiceImpl()
    private val orderService = OrderServiceImpl()

    @Test
    fun createOrder() {
        val memberId = "1"
        val member = Member(memberId, "memberA", Grade.VIP)
        memberService.join(member)

        val order = orderService.createOrder(memberId, "itemA", 10000)
        Assertions.assertThat(order.discountPrice).isEqualTo(1000)
    }
}