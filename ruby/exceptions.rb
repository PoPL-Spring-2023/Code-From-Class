# Can define our own exception classes
# Need to be a descendent of Exception

class MeanOfEmptyArrayError < ZeroDivisionError
    def to_s
        "Man, why did you try to find the mean of an empty array?"
    end
end

def mean(numbers)
    if numbers.size == 0
        # message = "Mean of empty array! #{numbers}"
        # raise ZeroDivisionError, message
        raise MeanOfEmptyArrayError
    end

    numbers.sum / numbers.length
end

# mean(6)
# mean([])
# mean(["asd", 5])

nums = []

begin
    puts "Enter some integers; leave line blank to stop."
    while gets.chomp != ''
        nums << $_.to_i
    end

    # nums = ["asd"]

    puts "Mean is: #{mean(nums)}"

rescue ZeroDivisionError => problem
    puts "You can't find the mean of zero numbers!"
    puts problem

    # raise
    retry

rescue TypeError => type_problem
    puts "There was something besides numbers in your array"
    print nums

end

## Ruby gives us a way to exit deep function calls
## Without throwing an exception


def print_big_no_space char
    if char == ' '
        throw :hit_a_space
    end
    puts char.upcase
end

catch :another_throw do
    catch :hit_a_space do
        puts "Enter a string:"
        string = gets.chomp
        string.each_char {|c| print_big_no_space c}
        throw :another_throw
        puts "We'll never get here!"
    end
    puts "Inside another throw"
end


puts "End of program"

