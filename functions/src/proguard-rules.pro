# Add any ProGuard configurations specific to this
# extension here.

-keep public class com.brandonang.functions.Functions {
    public *;
 }
-keeppackagenames gnu.kawa**, gnu.expr**

-optimizationpasses 4
-allowaccessmodification
-mergeinterfacesaggressively

-repackageclasses 'com/brandonang/functions/repack'
-flattenpackagehierarchy
-dontpreverify
