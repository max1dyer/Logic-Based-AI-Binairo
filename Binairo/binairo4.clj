{:name        "Binairo 4x4 Puzzle 1"
 :description "Simple 4x4 Binairo encoding with some givens"
 :assumptions {
   ;; --- No three 1s in a row, row 1 ---
   1  (not (and X11 X12 X13))
   2  (not (and X12 X13 X14))

   ;; --- No three 0s in a row, row 1 ---
   3  (not (and (not X11) (not X12) (not X13)))
   4  (not (and (not X12) (not X13) (not X14)))

   ;; --- No three 1s in column 1 ---
   5  (not (and X11 X21 X31))
   6  (not (and X21 X31 X41))

   ;; --- No three 0s in column 1 ---
   7  (not (and (not X11) (not X21) (not X31)))
   8  (not (and (not X21) (not X31) (not X41)))

   ;; --- Row 1 has exactly two 1s (all 6 combos) ---
   9  (or (and X11 X12 (not X13) (not X14))
         (and X11 X13 (not X12) (not X14))
         (and X11 X14 (not X12) (not X13))
         (and X12 X13 (not X11) (not X14))
         (and X12 X14 (not X11) (not X13))
         (and X13 X14 (not X11) (not X12)))

   ;; --- Column 1 has exactly two 1s ---
   10 (or (and X11 X21 (not X31) (not X41))
          (and X11 X31 (not X21) (not X41))
          (and X11 X41 (not X21) (not X31))
          (and X21 X31 (not X11) (not X41))
          (and X21 X41 (not X11) (not X31))
          (and X31 X41 (not X11) (not X21)))

   ;; --- Example givens for the puzzle ---
   ;; X11 is 1, X14 is 0, X23 is 1, X34 is 0
   11 X11
   12 (not X14)
   13 X23
   14 X31
   15 X33
   16 (not X34)
 }
 :goal        (and X12 (not X13) (not X21) (not X22) X24 (not X32) (not X41) X42 (not X43) X44)}
