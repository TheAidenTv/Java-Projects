# Quick Find

An algorithm that uses an array to store the set that each element belongs to. It performs union operations by changing all elements of one set to belong to the other set, and checks if two elements are in the same set by comparing their sets.

# Quick Union

An algorithm that uses an array to store the parent of each element and performs union operations by updating the parent of one element to the parent of the other, and checks if two elements have the same parent.

# Weighted Quick Union

An algorithm that improves on the Quick Union algorithm by keeping track of the size of each tree and always attaching the smaller tree to the larger one.

# Weighted Quick Union with Path Compression

An algorithm that improves on the Weighted Quick Union algorithm by compressing the paths between nodes and the root during find operations. This reduces the depth of the tree and improves performance. My implementation only needs 1 extra line of code and yet drastically improves the overall performance so there's really no reason not to do this.
