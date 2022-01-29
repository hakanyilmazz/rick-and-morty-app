import kotlin.reflect.KClass
import kotlin.reflect.full.declaredMemberProperties

object Util {
    fun <T : Any> toList(ofClass: KClass<T>): ArrayList<String> {
        val declaredMemberProperties = ofClass.declaredMemberProperties
        val list = arrayListOf<String>()

        for (item in declaredMemberProperties) {
            list.add(item.getter.call().toString())
        }

        return list
    }
}