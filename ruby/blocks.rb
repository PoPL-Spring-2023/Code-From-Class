
# Any class that defines the <=> and succ can be used in a range
# <=> gives comparisons
# succ gives the next element in a sequence
# require "date"

# today = Date.new(2023, 2, 9)
# puts today.succ

# semester_end = Date.new(2023, 5, 16)

# semester = (today..semester_end)

# puts semester

# semester.each {|date| puts date}

# puts semester.count

### block - anonymous function passed to a higher-order function
### anonymous function - a function defined without a name only where it is used
### higher-order function - function that takes a function as input OR creates and outputs a function

### Define our own higher-order function
def one_to_ten_squared
    i = 1
    while i <= 10
        x = yield i * i  # yield immediately calls the code block passed to this function on i * i
        i += 1
        puts "x is #{x}"
    end
end

# one_to_ten_squared do |n|
#     puts "The number is #{n}!"
#     n + 10000
# end

### why can't you use return in a code block
# one_to_ten_squared do |n|
#     puts n
#     if n > 10
#         "big"
#     else
#         "small"
#     end
# end

# def do_something_with_five_and_two
#     z = yield 5, 2
#     puts z
# end

# do_something_with_five_and_two {|x, y| x + y}

# do_something_with_five_and_two {|x, y| x * y}

# do_something_with_five_and_two {|x, y| x ** y}


### Common iterators - method that invokes a block of code
###  - work on many collections (Arrays, Hashes, Ranges, etc.)
###  - can make these work on our own classes as well!

a = [1, 3, 5, 7, 9]

### each - yields successive elements

# sum = 0
# a.each {|x| sum += x}
# puts sum

### find - finds the first element that makes a block true

# puts a.find {|n| n > 4}

### find_all - finds all elements that make a block true

# print a.find_all {|n| n > 4}
# puts

## Finds all prime numbers less than 100
# primes = (1..100).find_all do |num|
#     divisors = (1..num).find_all {|divisor| num % divisor == 0}
#     divisors.size == 2
# end

# print primes
# puts

### map (or collect) - creates a new array made by applying the block to each element

# print a.map {|n| n * n}
# puts

# print a.map {|n| n.to_s + "<--- this is a number"}
# puts

### File IO
### important to close files to make sure they're written properly
### if you use a code block to open the file, this is done automatically!

File.open("blocks.rb", 'r') do |file|
    file.each {|line| puts line}
end
