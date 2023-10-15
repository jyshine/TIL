fun main() {
    var neverNull: String = "This can't be null"

//    neverNull = null
    var nullVar: String? = null
    var nullable: String? = "You can keep a null here"
    nullable = null

    var inferredNonNull = "The compiler assumes non-null"

//    inferredNonNull = null

    fun strLength(notNull: String): Int {
        return notNull.length
    }

    println(strLength(neverNull)         )

    fun describeString(maybeString: String?): String {
        if (maybeString != null && maybeString.length > 0) {
            return "String of length ${maybeString.length}"
        } else {
            return "Empty or null string"
        }
    }
    println(describeString(nullVar)         )
//    strLength(nullable)


}