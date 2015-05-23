#!/bin/bash

gitstat=`git log --stat`
echo "$gitstat" | awk 'BEGIN {
    OFS = " "
    month["Jan"] = "01"
    month["Feb"] = "02"
    month["Mar"] = "03"
    month["Apr"] = "04"
    month["May"] = "05"
    month["Jun"] = "06"
    month["Jul"] = "07"
    month["Aug"] = "08"
    month["Sep"] = "09"
    month["Oct"] = "10"
    month["Nov"] = "11"
    month["Dec"] = "12"
} function addZero(n) {
    if (n < 10) {
        return "0"n
    }
    return n
} $1 ~ /Author:/ || $1 ~ /Date:/ || $0 ~ /insertions/ {
    if ($1 == "Author:") {
        author = $2
    } else if ($1 == "Date:") {
        date = $6"-"month[$3]"-"addZero($4)
    } else {
	count[date, author] += $4
	totalCount += $4
    }
} END {
    for (i in count) {
	split(i, p, "\034")
        print p[1], p[2], "submit", count[i], "lines"
    }
    print "total", "submit", totalCount, "lines"
}' | sort

