# This should be run in the directory above the Processing project folder

for file in $1/*.pde; do
  if [ "$(basename $file .pde)" != "$1" ]; then
    echo "$(basename $file .pde)"
    echo "$1"
    jfile="$1/$(basename $file .pde).java"
    cp $file $jfile
    echo -e "package $1;\n\n$(cat $jfile)" > $jfile
  fi
done
javadoc -tag pre:a:"Preconditions" -tag post:a:"Postconditions" -d $1/doc $1
rm $1/*.java
