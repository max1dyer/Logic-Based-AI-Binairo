{:name        "Binairo 6x6 Puzzle 1"
 :description "Simple 6x6 Binairo encoding with some givens"
 :assumptions {
   ;; --- No three 1s in a row, row 1 ---
   1  (and (not (and X11 X12 X13)) 
	   (not (and X12 X13 X14)) 
           (not (and X13 X14 X15)) 
	   (not (and X14 X15 X16)))

   ;; --- No three 1s in a row, row 2 ---
   2  (and (not (and X21 X22 X23)) 
	   (not (and X22 X23 X24)) 
	   (not (and X23 X24 X25)) 
	   (not (and X24 X25 X26)))

   ;; --- No three 1s in a row, row 3 ---
   3  (and (not (and X31 X32 X33)) 
	   (not (and X32 X33 X34)) 
	   (not (and X33 X34 X35)) 
	   (not (and X34 X35 X36)))

   ;; --- No three 1s in a row, row 4 ---
   4  (and (not (and X41 X42 X43)) 
	   (not (and X42 X43 X44)) 
	   (not (and X43 X44 X45)) 
	   (not (and X44 X45 X46)))

   ;; --- No three 1s in a row, row 5 ---
   5  (and (not (and X51 X52 X53)) 
	   (not (and X52 X53 X54)) 
	   (not (and X53 X54 X55)) 
	   (not (and X54 X55 X56)))

   ;; --- No three 1s in a row, row 6 ---
   6  (and (not (and X61 X62 X63)) 
	   (not (and X62 X63 X64)) 
	   (not (and X63 X64 X65)) 
	   (not (and X64 X65 X66)))

   ;; --- No three 0s in a row, row 1 ---
   7  (and (not (and (not X11) (not X12) (not X13))) 
	   (not (and (not X12) (not X13) (not X14))) 
	   (not (and (not X13) (not X14) (not X15))) 
	   (not (and (not X14) (not X15) (not X16))))

   ;; --- No three 0s in a row, row 2 ---
   8  (and (not (and (not X21) (not X22) (not X23))) 
	   (not (and (not X22) (not X23) (not X24))) 
	   (not (and (not X23) (not X24) (not X25))) 
	   (not (and (not X24) (not X25) (not X26))))

   ;; --- No three 0s in a row, row 3 ---
   9  (and (not (and (not X31) (not X32) (not X33))) 
	   (not (and (not X32) (not X33) (not X34))) 
	   (not (and (not X33) (not X34) (not X35))) 
	   (not (and (not X34) (not X35) (not X36))))

   ;; --- No three 0s in a row, row 4 ---
   10 (and (not (and (not X41) (not X42) (not X43))) 
	   (not (and (not X42) (not X43) (not X44))) 
	   (not (and (not X43) (not X44) (not X45))) 
	   (not (and (not X44) (not X45) (not X46))))

   ;; --- No three 0s in a row, row 5 ---
   11 (and (not (and (not X51) (not X52) (not X53))) 
	   (not (and (not X52) (not X53) (not X54))) 
	   (not (and (not X53) (not X54) (not X55))) 
	   (not (and (not X54) (not X55) (not X56))))

   ;; --- No three 0s in a row, row 6 ---
   12 (and (not (and (not X61) (not X62) (not X63))) 
	   (not (and (not X62) (not X63) (not X64))) 
	   (not (and (not X63) (not X64) (not X65))) 
	   (not (and (not X64) (not X65) (not X66))))

   ;; --- No three 1s in column 1 ---
   13 (and (not (and X11 X21 X31)) 
	   (not (and X21 X31 X41)) 
	   (not (and X31 X41 X51)) 
	   (not (and X41 X51 X61)))

   ;; --- No three 1s in column 2 ---
   14 (and (not (and X12 X22 X32)) 
	   (not (and X22 X32 X42)) 
	   (not (and X32 X42 X52)) 
	   (not (and X42 X52 X62)))

   ;; --- No three 1s in column 3 ---
   15 (and (not (and X13 X23 X33)) 
	   (not (and X23 X33 X43)) 
	   (not (and X33 X43 X53)) 
	   (not (and X43 X53 X63)))

   ;; --- No three 1s in column 4 ---
   16 (and (not (and X14 X24 X34)) 
	   (not (and X24 X34 X44)) 
	   (not (and X34 X44 X54)) 
	   (not (and X44 X54 X64)))

   ;; --- No three 1s in column 5 ---
   17 (and (not (and X15 X25 X35)) 
	   (not (and X25 X35 X45)) 
	   (not (and X35 X45 X55)) 
	   (not (and X45 X55 X65)))

   ;; --- No three 1s in column 6 ---
   18 (and (not (and X16 X26 X36)) 
	   (not (and X26 X36 X46)) 
	   (not (and X36 X46 X56)) 
	   (not (and X46 X56 X66)))

   ;; --- No three 0s in column 1 ---
   19 (and (not (and (not X11) (not X21) (not X31))) 
	   (not (and (not X21) (not X31) (not X41))) 
	   (not (and (not X31) (not X41) (not X51))) 
           (not (and (not X41) (not X51) (not X61))))

   ;; --- No three 0s in column 2 ---
   20 (and (not (and (not X12) (not X22) (not X32))) 
	   (not (and (not X22) (not X32) (not X42))) 
	   (not (and (not X32) (not X42) (not X52))) 
           (not (and (not X42) (not X52) (not X62))))

   ;; --- No three 0s in column 3 ---
   21 (and (not (and (not X13) (not X23) (not X33))) 
	   (not (and (not X23) (not X33) (not X43))) 
	   (not (and (not X33) (not X43) (not X53))) 
           (not (and (not X43) (not X53) (not X63))))

   ;; --- No three 0s in column 4 ---
   22 (and (not (and (not X14) (not X24) (not X34))) 
	   (not (and (not X24) (not X34) (not X44))) 
	   (not (and (not X34) (not X44) (not X54))) 
           (not (and (not X44) (not X54) (not X64))))

   ;; --- No three 0s in column 5 ---
   23 (and (not (and (not X15) (not X25) (not X35))) 
	   (not (and (not X25) (not X35) (not X45))) 
	   (not (and (not X35) (not X45) (not X55))) 
           (not (and (not X45) (not X55) (not X65))))

   ;; --- No three 0s in column 6 ---
   24 (and (not (and (not X16) (not X26) (not X36))) 
	   (not (and (not X26) (not X36) (not X46))) 
	   (not (and (not X36) (not X46) (not X56))) 
           (not (and (not X46) (not X56) (not X66))))

   ;; --- Row 1 has exactly three 1s (all 14 combos) ---
   25 (or (and X11 X12 X14 (not X13) (not X15) (not X16))
          (and X11 X12 X15 (not X13) (not X14) (not X16))
          (and X11 X13 X14 (not X12) (not X15) (not X16))
          (and X11 X13 X15 (not X12) (not X14) (not X16))
          (and X11 X13 X16 (not X12) (not X14) (not X15))
          (and X11 X14 X15 (not X12) (not X13) (not X16))
          (and X11 X14 X16 (not X12) (not X13) (not X15))
          (and X12 X13 X15 (not X11) (not X14) (not X16))
          (and X12 X13 X16 (not X11) (not X14) (not X15))
          (and X12 X14 X15 (not X11) (not X13) (not X16))
          (and X12 X14 X16 (not X11) (not X13) (not X15))
          (and X12 X15 X16 (not X11) (not X13) (not X14))
          (and X13 X14 X16 (not X11) (not X12) (not X15))
          (and X13 X15 X16 (not X11) (not X12) (not X14)))

   ;; --- Row 2 has exactly three 1s (all 14 combos) ---
   26 (or (and X21 X22 X24 (not X23) (not X25) (not X26))
          (and X21 X22 X25 (not X23) (not X24) (not X26))
          (and X21 X23 X24 (not X22) (not X25) (not X26))
          (and X21 X23 X25 (not X22) (not X24) (not X26))
          (and X21 X23 X26 (not X22) (not X24) (not X25))
          (and X21 X24 X25 (not X22) (not X23) (not X26))
          (and X21 X24 X26 (not X22) (not X23) (not X25))
          (and X22 X23 X25 (not X21) (not X24) (not X26))
          (and X22 X23 X26 (not X21) (not X24) (not X25))
          (and X22 X24 X25 (not X21) (not X23) (not X26))
          (and X22 X24 X26 (not X21) (not X23) (not X25))
          (and X22 X25 X26 (not X21) (not X23) (not X24))
          (and X23 X24 X26 (not X21) (not X22) (not X25))
          (and X23 X25 X26 (not X21) (not X22) (not X24)))

   ;; --- Row 3 has exactly three 1s (all 14 combos) ---
   27 (or (and X31 X32 X34 (not X33) (not X35) (not X36))
          (and X31 X32 X35 (not X33) (not X34) (not X36))
          (and X31 X33 X34 (not X32) (not X35) (not X36))
          (and X31 X33 X35 (not X32) (not X34) (not X36))
          (and X31 X33 X36 (not X32) (not X34) (not X35))
          (and X31 X34 X35 (not X32) (not X33) (not X36))
          (and X31 X34 X36 (not X32) (not X33) (not X35))
          (and X32 X33 X35 (not X31) (not X34) (not X36))
          (and X32 X33 X36 (not X31) (not X34) (not X35))
          (and X32 X34 X35 (not X31) (not X33) (not X36))
          (and X32 X34 X36 (not X31) (not X33) (not X35))
          (and X32 X35 X36 (not X31) (not X33) (not X34))
          (and X33 X34 X36 (not X31) (not X32) (not X35))
          (and X33 X35 X36 (not X31) (not X32) (not X34)))

   ;; --- Row 4 has exactly three 1s (all 14 combos) ---
   28 (or (and X41 X42 X44 (not X43) (not X45) (not X46))
          (and X41 X42 X45 (not X43) (not X44) (not X46))
          (and X41 X43 X44 (not X42) (not X45) (not X46))
          (and X41 X43 X45 (not X42) (not X44) (not X46))
          (and X41 X43 X46 (not X42) (not X44) (not X45))
          (and X41 X44 X45 (not X42) (not X43) (not X46))
          (and X41 X44 X46 (not X42) (not X43) (not X45))
          (and X42 X43 X45 (not X41) (not X44) (not X46))
          (and X42 X43 X46 (not X41) (not X44) (not X45))
          (and X42 X44 X45 (not X41) (not X43) (not X46))
          (and X42 X44 X46 (not X41) (not X43) (not X45))
          (and X42 X45 X46 (not X41) (not X43) (not X44))
          (and X43 X44 X46 (not X41) (not X42) (not X45))
          (and X43 X45 X46 (not X41) (not X42) (not X44)))

   ;; --- Row 5 has exactly three 1s (all 14 combos) ---
   29 (or (and X51 X52 X54 (not X53) (not X55) (not X56))
          (and X51 X52 X55 (not X53) (not X54) (not X56))
          (and X51 X53 X54 (not X52) (not X55) (not X56))
          (and X51 X53 X55 (not X52) (not X54) (not X56))
          (and X51 X53 X56 (not X52) (not X54) (not X55))
          (and X51 X54 X55 (not X52) (not X53) (not X56))
          (and X51 X54 X56 (not X52) (not X53) (not X55))
          (and X52 X53 X55 (not X51) (not X54) (not X56))
          (and X52 X53 X56 (not X51) (not X54) (not X55))
          (and X52 X54 X55 (not X51) (not X53) (not X56))
          (and X52 X54 X56 (not X51) (not X53) (not X55))
          (and X52 X55 X56 (not X51) (not X53) (not X54))
          (and X53 X54 X56 (not X51) (not X52) (not X55))
          (and X53 X55 X56 (not X51) (not X52) (not X54)))

   ;; --- Row 6 has exactly three 1s (all 14 combos) ---
   30 (or (and X61 X62 X64 (not X63) (not X65) (not X66))
          (and X61 X62 X65 (not X63) (not X64) (not X66))
          (and X61 X63 X64 (not X62) (not X65) (not X66))
          (and X61 X63 X65 (not X62) (not X64) (not X66))
          (and X61 X63 X66 (not X62) (not X64) (not X65))
          (and X61 X64 X65 (not X62) (not X63) (not X66))
          (and X61 X64 X66 (not X62) (not X63) (not X65))
          (and X62 X63 X65 (not X61) (not X64) (not X66))
          (and X62 X63 X66 (not X61) (not X64) (not X65))
          (and X62 X64 X65 (not X61) (not X63) (not X66))
          (and X62 X64 X66 (not X61) (not X63) (not X65))
          (and X62 X65 X66 (not X61) (not X63) (not X64))
          (and X63 X64 X66 (not X61) (not X62) (not X65))
          (and X63 X65 X66 (not X61) (not X62) (not X64)))

   ;; --- Column 1 has exactly three 1s (all 14 combos) ---
   31 (or (and X11 X21 X41 (not X31) (not X51) (not X61))
          (and X11 X21 X51 (not X31) (not X41) (not X61))
          (and X11 X31 X41 (not X21) (not X51) (not X61))
          (and X11 X31 X51 (not X21) (not X41) (not X61))
          (and X11 X31 X61 (not X21) (not X41) (not X51))
          (and X11 X41 X51 (not X21) (not X31) (not X61))
          (and X11 X41 X61 (not X21) (not X31) (not X51))
          (and X21 X31 X51 (not X11) (not X41) (not X61))
          (and X21 X31 X61 (not X11) (not X41) (not X51))
          (and X21 X41 X51 (not X11) (not X31) (not X61))
          (and X21 X41 X61 (not X11) (not X31) (not X51))
          (and X21 X51 X61 (not X11) (not X31) (not X41))
          (and X31 X41 X61 (not X11) (not X21) (not X51))
          (and X31 X51 X61 (not X11) (not X21) (not X41)))

   ;; --- Column 2 has exactly three 1s (all 14 combos) ---
   32 (or (and X12 X22 X42 (not X32) (not X52) (not X62))
          (and X12 X22 X52 (not X32) (not X42) (not X62))
          (and X12 X32 X42 (not X22) (not X52) (not X62))
          (and X12 X32 X52 (not X22) (not X42) (not X62))
          (and X12 X32 X62 (not X22) (not X42) (not X52))
          (and X12 X42 X52 (not X22) (not X32) (not X62))
          (and X12 X42 X62 (not X22) (not X32) (not X52))
          (and X22 X32 X52 (not X12) (not X42) (not X62))
          (and X22 X32 X62 (not X12) (not X42) (not X52))
          (and X22 X42 X52 (not X12) (not X32) (not X62))
          (and X22 X42 X62 (not X12) (not X32) (not X52))
          (and X22 X52 X62 (not X12) (not X32) (not X42))
          (and X32 X42 X62 (not X12) (not X22) (not X52))
          (and X32 X52 X62 (not X12) (not X22) (not X42)))

   ;; --- Column 3 has exactly three 1s (all 14 combos) ---
   31 (or (and X13 X23 X43 (not X33) (not X53) (not X63))
          (and X13 X23 X53 (not X33) (not X43) (not X63))
          (and X13 X33 X43 (not X23) (not X53) (not X63))
          (and X13 X33 X53 (not X23) (not X43) (not X63))
          (and X13 X33 X63 (not X23) (not X43) (not X53))
          (and X13 X43 X53 (not X23) (not X33) (not X63))
          (and X13 X43 X63 (not X23) (not X33) (not X53))
          (and X23 X33 X53 (not X13) (not X43) (not X63))
          (and X23 X33 X63 (not X13) (not X43) (not X53))
          (and X23 X43 X53 (not X13) (not X33) (not X63))
          (and X23 X43 X63 (not X13) (not X33) (not X53))
          (and X23 X53 X63 (not X13) (not X33) (not X43))
          (and X33 X43 X63 (not X13) (not X23) (not X53))
          (and X33 X53 X63 (not X13) (not X23) (not X43)))

   ;; --- Column 4 has exactly three 1s (all 14 combos) ---
   34 (or (and X14 X24 X44 (not X34) (not X54) (not X64))
          (and X14 X24 X54 (not X34) (not X44) (not X64))
          (and X14 X34 X44 (not X24) (not X54) (not X64))
          (and X14 X34 X54 (not X24) (not X44) (not X64))
          (and X14 X34 X64 (not X24) (not X44) (not X54))
          (and X14 X44 X54 (not X24) (not X34) (not X64))
          (and X14 X44 X64 (not X24) (not X34) (not X54))
          (and X24 X34 X54 (not X14) (not X44) (not X64))
          (and X24 X34 X64 (not X14) (not X44) (not X54))
          (and X24 X44 X54 (not X14) (not X34) (not X64))
          (and X24 X44 X64 (not X14) (not X34) (not X54))
          (and X24 X54 X64 (not X14) (not X34) (not X44))
          (and X34 X44 X64 (not X14) (not X24) (not X54))
          (and X34 X54 X64 (not X14) (not X24) (not X44)))

   ;; --- Column 5 has exactly three 1s (all 14 combos) ---
   35 (or (and X15 X25 X45 (not X35) (not X55) (not X65))
          (and X15 X25 X55 (not X35) (not X45) (not X65))
          (and X15 X35 X45 (not X25) (not X55) (not X65))
          (and X15 X35 X55 (not X25) (not X45) (not X65))
          (and X15 X35 X65 (not X25) (not X45) (not X55))
          (and X15 X45 X55 (not X25) (not X35) (not X65))
          (and X15 X45 X65 (not X25) (not X35) (not X55))
          (and X25 X35 X55 (not X15) (not X45) (not X65))
          (and X25 X35 X65 (not X15) (not X45) (not X55))
          (and X25 X45 X55 (not X15) (not X35) (not X65))
          (and X25 X45 X65 (not X15) (not X35) (not X55))
          (and X25 X55 X65 (not X15) (not X35) (not X45))
          (and X35 X45 X65 (not X15) (not X25) (not X55))
          (and X35 X55 X65 (not X15) (not X25) (not X45)))

   ;; --- Column 6 has exactly three 1s (all 14 combos) ---
   36 (or (and X16 X26 X46 (not X36) (not X56) (not X66))
          (and X16 X26 X56 (not X36) (not X46) (not X66))
          (and X16 X36 X46 (not X26) (not X56) (not X66))
          (and X16 X36 X56 (not X26) (not X46) (not X66))
          (and X16 X36 X66 (not X26) (not X46) (not X56))
          (and X16 X46 X56 (not X26) (not X36) (not X66))
          (and X16 X46 X66 (not X26) (not X36) (not X56))
          (and X26 X36 X56 (not X16) (not X46) (not X66))
          (and X26 X36 X66 (not X16) (not X46) (not X56))
          (and X26 X46 X56 (not X16) (not X36) (not X66))
          (and X26 X46 X66 (not X16) (not X36) (not X56))
          (and X26 X56 X66 (not X16) (not X36) (not X46))
          (and X36 X46 X66 (not X16) (not X26) (not X56))
          (and X36 X56 X66 (not X16) (not X26) (not X46)))

   ;; --- Row 1 and Row 2 are not identical ---
   37 (or (and X11 (not X21)) (and (not X11) X21)
           (and X12 (not X22)) (and (not X12) X22)
           (and X13 (not X23)) (and (not X13) X23)
           (and X14 (not X24)) (and (not X14) X24)
           (and X15 (not X25)) (and (not X15) X25)
           (and X16 (not X26)) (and (not X16) X26))

   ;; --- Row 1 and Row 3 are not identical ---
   38 (or (and X11 (not X31)) (and (not X11) X31)
          (and X12 (not X32)) (and (not X12) X32)
          (and X13 (not X33)) (and (not X13) X33)
          (and X14 (not X34)) (and (not X14) X34)
          (and X15 (not X35)) (and (not X15) X35)
          (and X16 (not X36)) (and (not X16) X36))

   ;; --- Row 1 and Row 4 are not identical ---
   39 (or (and X11 (not X41)) (and (not X11) X41)
          (and X12 (not X42)) (and (not X12) X42)
          (and X13 (not X43)) (and (not X13) X43)
          (and X14 (not X44)) (and (not X14) X44)
          (and X15 (not X45)) (and (not X15) X45)
          (and X16 (not X46)) (and (not X16) X46))
  
   ;; --- Row 1 and Row 5 are not identical ---
   40 (or (and X11 (not X51)) (and (not X11) X51)
          (and X12 (not X52)) (and (not X12) X52)
          (and X13 (not X53)) (and (not X13) X53)
          (and X14 (not X54)) (and (not X14) X54)
          (and X15 (not X55)) (and (not X15) X55)
          (and X16 (not X56)) (and (not X16) X56))

   ;; --- Row 1 and Row 6 are not identical ---
   41 (or (and X11 (not X61)) (and (not X11) X61)
          (and X12 (not X62)) (and (not X12) X62)
          (and X13 (not X63)) (and (not X13) X63)
          (and X14 (not X64)) (and (not X14) X64)
          (and X15 (not X65)) (and (not X15) X65)
          (and X16 (not X66)) (and (not X16) X66))

   ;; --- Row 2 and Row 3 are not identical ---
   42 (or (and X21 (not X31)) (and (not X21) X31)
          (and X22 (not X32)) (and (not X22) X32)
          (and X23 (not X33)) (and (not X23) X33)
          (and X24 (not X34)) (and (not X24) X34)
          (and X25 (not X35)) (and (not X25) X35)
          (and X26 (not X36)) (and (not X26) X36))

   ;; --- Row 2 and Row 4 are not identical ---
   43 (or (and X21 (not X41)) (and (not X21) X41)
          (and X22 (not X42)) (and (not X22) X42)
          (and X23 (not X43)) (and (not X23) X43)
          (and X24 (not X44)) (and (not X24) X44)
          (and X25 (not X45)) (and (not X25) X45)
          (and X26 (not X46)) (and (not X26) X46))

   ;; --- Row 2 and Row 5 are not identical ---
   44 (or (and X21 (not X51)) (and (not X21) X51)
          (and X22 (not X52)) (and (not X22) X52)
          (and X23 (not X53)) (and (not X23) X53)
          (and X24 (not X54)) (and (not X24) X54)
          (and X25 (not X55)) (and (not X25) X55)
          (and X26 (not X56)) (and (not X26) X56))
 
   ;; --- Row 2 and Row 6 are not identical ---
   45 (or (and X21 (not X61)) (and (not X21) X61)
          (and X22 (not X62)) (and (not X22) X62)
          (and X23 (not X63)) (and (not X23) X63)
          (and X24 (not X64)) (and (not X24) X64)
          (and X25 (not X65)) (and (not X25) X65)
          (and X26 (not X66)) (and (not X26) X66))

   ;; --- Row 3 and Row 4 are not identical ---
   46 (or (and X31 (not X41)) (and (not X31) X41)
          (and X32 (not X42)) (and (not X32) X42)
          (and X33 (not X43)) (and (not X33) X43)
          (and X34 (not X44)) (and (not X34) X44)
          (and X35 (not X45)) (and (not X35) X45)
          (and X36 (not X46)) (and (not X36) X46))

   ;; --- Row 3 and Row 5 are not identical ---
   47 (or (and X31 (not X51)) (and (not X31) X51)
          (and X32 (not X52)) (and (not X32) X52)
          (and X33 (not X53)) (and (not X33) X53)
          (and X34 (not X54)) (and (not X34) X54)
          (and X35 (not X55)) (and (not X35) X55)
          (and X36 (not X56)) (and (not X36) X56))

   ;; --- Row 3 and Row 6 are not identical ---
   48 (or (and X31 (not X61)) (and (not X31) X61)
          (and X32 (not X62)) (and (not X32) X62)
          (and X33 (not X63)) (and (not X33) X63)
          (and X34 (not X64)) (and (not X34) X64)
          (and X35 (not X65)) (and (not X35) X65)
          (and X36 (not X66)) (and (not X36) X66))

   ;; --- Row 4 and Row 5 are not identical ---
   49 (or (and X41 (not X51)) (and (not X41) X51)
          (and X42 (not X52)) (and (not X42) X52)
          (and X43 (not X53)) (and (not X43) X53)
          (and X44 (not X54)) (and (not X44) X54)
          (and X45 (not X55)) (and (not X45) X55)
          (and X46 (not X56)) (and (not X46) X56))

   ;; --- Row 4 and Row 6 are not identical ---
   50 (or (and X41 (not X61)) (and (not X41) X61)
          (and X42 (not X62)) (and (not X42) X62)
          (and X43 (not X63)) (and (not X43) X63)
          (and X44 (not X64)) (and (not X44) X64)
          (and X45 (not X65)) (and (not X45) X65)
          (and X46 (not X66)) (and (not X46) X66))

   ;; --- Row 5 and Row 6 are not identical ---
   51 (or (and X51 (not X61)) (and (not X51) X61)
          (and X52 (not X62)) (and (not X52) X62)
          (and X53 (not X63)) (and (not X53) X63)
          (and X54 (not X64)) (and (not X54) X64)
          (and X55 (not X65)) (and (not X55) X65)
          (and X56 (not X66)) (and (not X56) X66))

   ;; --- Column 1 and Column 2 are not identical ---
   52 (or (and X11 (not X12)) (and (not X11) X12)
          (and X21 (not X22)) (and (not X21) X22)
          (and X31 (not X32)) (and (not X31) X32)
          (and X41 (not X42)) (and (not X41) X42)
          (and X51 (not X52)) (and (not X51) X52)
          (and X61 (not X62)) (and (not X61) X62))

   ;; --- Column 1 and Column 3 are not identical ---
   53 (or (and X11 (not X13)) (and (not X11) X13)
          (and X21 (not X23)) (and (not X21) X23)
          (and X31 (not X33)) (and (not X31) X33)
          (and X41 (not X43)) (and (not X41) X43)
          (and X51 (not X53)) (and (not X51) X53)
          (and X61 (not X63)) (and (not X61) X63))

   ;; --- Column 1 and Column 4 are not identical ---
   54 (or (and X11 (not X14)) (and (not X11) X14)
          (and X21 (not X24)) (and (not X21) X24)
          (and X31 (not X34)) (and (not X31) X34)
          (and X41 (not X44)) (and (not X41) X44)
          (and X51 (not X54)) (and (not X51) X54)
          (and X61 (not X64)) (and (not X61) X64))

   ;; --- Column 1 and Column 5 are not identical ---
   55 (or (and X11 (not X15)) (and (not X11) X15)
          (and X21 (not X25)) (and (not X21) X25)
          (and X31 (not X35)) (and (not X31) X35)
          (and X41 (not X45)) (and (not X41) X45)
          (and X51 (not X55)) (and (not X51) X55)
          (and X61 (not X65)) (and (not X61) X65))

   ;; --- Column 1 and Column 6 are not identical ---
   56 (or (and X11 (not X16)) (and (not X11) X16)
          (and X21 (not X26)) (and (not X21) X26)
          (and X31 (not X36)) (and (not X31) X36)
          (and X41 (not X46)) (and (not X41) X46)
          (and X51 (not X56)) (and (not X51) X56)
          (and X61 (not X66)) (and (not X61) X66))

   ;; --- Column 2 and Column 3 are not identical ---
   57 (or (and X12 (not X13)) (and (not X12) X13)
          (and X22 (not X23)) (and (not X22) X23)
          (and X32 (not X33)) (and (not X32) X33)
          (and X42 (not X43)) (and (not X42) X43)
          (and X52 (not X53)) (and (not X52) X53)
          (and X62 (not X63)) (and (not X62) X63))

   ;; --- Column 2 and Column 4 are not identical ---
   58 (or (and X12 (not X14)) (and (not X12) X14)
          (and X22 (not X24)) (and (not X22) X24)
          (and X32 (not X34)) (and (not X32) X34)
          (and X42 (not X44)) (and (not X42) X44)
          (and X52 (not X54)) (and (not X52) X54)
          (and X62 (not X64)) (and (not X62) X64))

   ;; --- Column 2 and Column 5 are not identical ---
   59 (or (and X12 (not X15)) (and (not X12) X15)
          (and X22 (not X25)) (and (not X22) X25)
          (and X32 (not X35)) (and (not X32) X35)
          (and X42 (not X45)) (and (not X42) X45)
          (and X52 (not X55)) (and (not X52) X55)
          (and X62 (not X65)) (and (not X62) X65))

   ;; --- Column 2 and Column 6 are not identical ---
   60 (or (and X12 (not X16)) (and (not X12) X16)
          (and X22 (not X26)) (and (not X22) X26)
          (and X32 (not X36)) (and (not X32) X36)
          (and X42 (not X46)) (and (not X42) X46)
          (and X52 (not X56)) (and (not X52) X56)
          (and X62 (not X66)) (and (not X62) X66))

   ;; --- Column 3 and Column 4 are not identical ---
   61 (or (and X13 (not X14)) (and (not X13) X14)
          (and X23 (not X24)) (and (not X23) X24)
          (and X33 (not X34)) (and (not X33) X34)
          (and X43 (not X44)) (and (not X43) X44)
          (and X53 (not X54)) (and (not X53) X54)
          (and X63 (not X64)) (and (not X63) X64))
 
   ;; --- Column 3 and Column 5 are not identical ---
   62 (or (and X13 (not X15)) (and (not X13) X15)
          (and X23 (not X25)) (and (not X23) X25)
          (and X33 (not X35)) (and (not X33) X35)
          (and X43 (not X45)) (and (not X43) X45)
          (and X53 (not X55)) (and (not X53) X55)
          (and X63 (not X65)) (and (not X63) X65))

   ;; --- Column 3 and Column 6 are not identical ---
   63 (or (and X13 (not X16)) (and (not X13) X16)
          (and X23 (not X26)) (and (not X23) X26)
          (and X33 (not X36)) (and (not X33) X36)
          (and X43 (not X46)) (and (not X43) X46)
          (and X53 (not X56)) (and (not X53) X56)
          (and X63 (not X66)) (and (not X63) X66))

   ;; --- Column 4 and Column 5 are not identical ---
   64 (or (and X14 (not X15)) (and (not X14) X15)
          (and X24 (not X25)) (and (not X24) X25)
          (and X34 (not X35)) (and (not X34) X35)
          (and X44 (not X45)) (and (not X44) X45)
          (and X54 (not X55)) (and (not X54) X55)
          (and X64 (not X65)) (and (not X64) X65))

   ;; --- Column 4 and Column 6 are not identical ---
   65 (or (and X14 (not X16)) (and (not X14) X16)
          (and X24 (not X26)) (and (not X24) X26)
          (and X34 (not X36)) (and (not X34) X36)
          (and X44 (not X46)) (and (not X44) X46)
          (and X54 (not X56)) (and (not X54) X56)
          (and X64 (not X66)) (and (not X64) X66))

   ;; --- Column 5 and Column 6 are not identical ---
   66 (or (and X15 (not X16)) (and (not X15) X16)
          (and X25 (not X26)) (and (not X25) X26)
          (and X35 (not X36)) (and (not X35) X36)
          (and X45 (not X46)) (and (not X45) X46)
          (and X55 (not X56)) (and (not X55) X56)
          (and X65 (not X66)) (and (not X65) X66))

   ;; --- Example givens for the puzzle ---
   ;; X11 is 0, X12 is 1, X24 is 0, X25 is 1, X33 is 0, X42 is 1, X44 is 0, X46 is 0, X56 is 0, X63 is 0, X64 is 0
   67 (not X11)
   68 X12
   69 (not X24)
   70 X25
   71 (not X33)
   72 X42
   73 (not X44)
   74 (not X46)
   75 (not X56)
   76 (not X63)
   77 (not X64)
 }
 :goal        }
