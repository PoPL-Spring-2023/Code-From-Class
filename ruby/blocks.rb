
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

### each - yields successive elements
a = [1, 3, 5, 7, 9]

sum = 0
a.each {|x| sum += x}
puts sum