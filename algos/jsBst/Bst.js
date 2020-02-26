class Bst {
    constructor() {
        this.root = null;
    }
    empty() {
        return this.root === null;
    }
    displayOnDom(node=this.root, parent=document.getElementById("root"), side="root-node") {
        // build html elements representing tree
        // create li for node value
        var el = document.createElement("li");
        el.setAttribute("class", side)
        el.innerText = node.value;

        // append li with value to parent
        parent.appendChild(el);

        // if node has children
        if(!node.isLeaf()) {
            // build ul for node's children
            var childList = document.createElement("ul");
            // append ul to parent
            parent.appendChild(childList);

            // if left child, descend
            if(node.left !== null) {
                this.displayOnDom(node.left, childList, "left");
            }
            if(node.right !== null) {
                this.displayOnDom(node.right, childList, "right");
            }
        }
    }
    add(value, node=this.root) {
        // if empty, set new node to root
        // AND EXIT
        if(this.empty()) {
            this.root = new BstNode(value);
            return;
        }

        if(node === null) {
            return;
        }

        // determine which side to add
        var goLeft = (node.value > value);

        if(goLeft) {
            // check if child node present
            if(node.left !== null) {
                return this.add(value, node.left);
            }
            node.left = new BstNode(value);
        } else {
            // check if child node present
            if(node.right !== null) {
                return this.add(value, node.right);
            }
            node.right = new BstNode(value);
        }
    }
}