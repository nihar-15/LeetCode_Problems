func addStrings(num1 string, num2 string) string {
    carry := 0
    var str strings.Builder

    i := len(num1) - 1
    j := len(num2) - 1

    for i >= 0 || j >= 0 || carry != 0 {
        var x, y int

        if i >= 0 {
            x = int(num1[i] - '0')
        } else {
            x = 0
        }

        if j >= 0 {
            y = int(num2[j] - '0')
        } else {
            y = 0
        }

        sum := x + y + carry
        str.WriteByte(byte(sum%10) + '0')
        carry = sum / 10

        i--
        j--
    }

    result := str.String()
    runes := []rune(result)
    for k, n := 0, len(runes); k < n/2; k++ {
        runes[k], runes[n-1-k] = runes[n-1-k], runes[k]
    }

    return string(runes)
    
}