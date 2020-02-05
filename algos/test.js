var leeMap = {
    firstName = "Lee",
    lastName = "Douglas"
};

var leeArray = ["Lee", "Douglas"]

// O(1)
leeMap.firstName; // => "Lee"

// O(N)
leeArray[0];

// we take a "key"
var key = "firstName";

// we convert that key into a hashCode
//