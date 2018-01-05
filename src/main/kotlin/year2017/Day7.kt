package year2017

class Day7 {
    fun doIt(input: String): String {
        val nodes = HashMap<String, Node>()

        val lines = input.split("\n")
        lines.forEach {
            val split = it.split("->")
            val node = Node(split.first().split(" ").first(), 0)
            nodes.put(node.id, node)
            if (split.size > 1) {
                node.stringChildren.addAll(split.last().trim().split(", "))
            }
        }

        nodes.entries.forEach {
            val node = it.value
            node.stringChildren.forEach {
                print(it)
                node.children.add(nodes[it]!!)
            }
        }

        return nodes.entries.map { it.value }.maxBy { it.getNumberOfChildren() }!!.id
    }

    fun thisOneSucks(input: String): Int {
        val nodes = HashMap<String, Node>()

        val lines = input.trim().split("\n")
        lines.forEach {
            val split = it.split("->")
            val weight = getWeight(split.first())
            val node = Node(split.first().split(" ").first(), weight)
            nodes.put(node.id, node)
            if (split.size > 1) {
                node.stringChildren.addAll(split.last().trim().split(", "))
            }
        }

        nodes.entries.forEach {
            val node = it.value
            node.stringChildren.forEach {
                print(it)
                node.children.add(nodes[it]!!)
            }
        }

        val unBlanced = nodes.values.filter { !it.isBalanced() && it.children.isNotEmpty() && it.isChildrenBalanced() }.first()

        val magic = unBlanced.children.groupBy { it.getCombinedWeight() }

        val different = magic.values.first { it.size == 1 }.first()
        val normal = magic.values.first { it.size != 1 }.first()

        return different.weight - (different.getCombinedWeight() - normal.getCombinedWeight())
    }

    private fun getWeight(input: String): Int {
        return input.trim().split(" ").last().substring(IntRange(1, input.trim().split(" ").last().length - 2)).toInt()
    }

    data class Node(
            val id: String,
            val weight: Int,
            val stringChildren: ArrayList<String> = ArrayList(),
            val children: ArrayList<Node> = ArrayList()
    ) {
        fun getNumberOfChildren(): Int = if (children.isEmpty()) 0 else children.fold(0, { acc: Int, node: Node ->
            (acc + 1 + node.getNumberOfChildren())
        })

        fun getCombinedWeight(): Int {
            return weight + children.sumBy { it.getCombinedWeight() }
        }

        fun isBalanced(): Boolean {
            if (children.isEmpty()) return true

            return children.groupBy { it.getCombinedWeight() }.size == 1
        }

        fun isChildrenBalanced(): Boolean {
            return children.filter { it.children.groupBy { it.getCombinedWeight() }.size != 1 }.count() == 0
        }

    }
}