# Open classes
# We can take existing classes and add behavior
# Even if we didn't create those classes!

class String

    # Return true if a string is entirely made of capital letters
    # Actually returns the index of match if it is all caps, and
    # nil otherwise, but both can be used for booleans
    def caps?
        return self =~ /\A[A-Z]+\Z/
        # return self =~ /\A[A-Z][A-Z][A-Z]/
    end

    # def size
    #     return 17
    # end

end

puts "hello".size

class Integer

    # Maps a code block over all square numbers between 0 and self
    # Returns array of results
    def map_over_squares
        x = 0
        results = []

        while x * x < self
            result = yield x * x
            results << result
            x += 1
        end

    return results
    end

    # def +(other)
    #     self - other
    # end
end

puts(100 + 40)