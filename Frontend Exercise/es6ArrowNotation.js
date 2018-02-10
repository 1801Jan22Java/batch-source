/* ES5 */
odds  = evens.map(function (v) { return v + 1; });
pairs = evens.map(function (v) { return { even: v, odd: v + 1 }; });
nums  = evens.map(function (v, i) { return v + i; });
/* ES6 */
odds  = evens.map(v => v + 1)
pairs = evens.map(v => ({ even: v, odd: v + 1 }))
nums  = evens.map((v, i) => v + i)

/* ES5 */
nums.forEach(function (v) {
   if (v % 5 === 0)
       fives.push(v);
});
/* ES6 */
nums.forEach(v => {
   if (v % 5 === 0)
       fives.push(v)
})

/* ES5 */
//  variant 1
var self = this;
this.nums.forEach(function (v) {
    if (v % 5 === 0)
        self.fives.push(v);
});

//  variant 2
this.nums.forEach(function (v) {
    if (v % 5 === 0)
        this.fives.push(v);
}, this);

//  variant 3 (since ECMAScript 5.1 only)
this.nums.forEach(function (v) {
    if (v % 5 === 0)
        this.fives.push(v);
}.bind(this));

/* ES6 */
this.nums.forEach((v) => {
    if (v % 5 === 0)
        this.fives.push(v)
})