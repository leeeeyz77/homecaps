package com.example.homecapsapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

public class CaptureShowActivity extends AppCompatActivity {

    ImageView load;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captureshow);
        Intent Bintent = new Intent(this, dialogActivity.class);
        ImageView im1, im2, im3, im4, im5, im6, im7, im8, im9, im10, im11, im12, im13, im14, im15;

        im1 = (ImageView)findViewById(R.id.iv1);
        im2 = (ImageView)findViewById(R.id.iv2);
        im3 = (ImageView)findViewById(R.id.iv3);
        im4 = (ImageView)findViewById(R.id.iv4);
        im5 = (ImageView)findViewById(R.id.iv5);
        im6 = (ImageView)findViewById(R.id.iv6);
        im7 = (ImageView)findViewById(R.id.iv7);
        im8 = (ImageView)findViewById(R.id.iv8);
        im9 = (ImageView)findViewById(R.id.iv9);
        im10 = (ImageView)findViewById(R.id.iv10);
        im11 = (ImageView)findViewById(R.id.iv11);
        im12 = (ImageView)findViewById(R.id.iv12);
        im13 = (ImageView)findViewById(R.id.iv13);
        im14 = (ImageView)findViewById(R.id.iv14);
        im15 = (ImageView)findViewById(R.id.iv15);

        getSupportActionBar().setTitle("firebase");

        //액티비티에서 사용할 이미지 뷰
//        FirebaseStorage storage = FirebaseStorage.getInstance();
//        StorageReference storageReference = storage.getReference();
//        StorageReference pathReference = storageReference.child("gs://homecaps.appspot.com/Photo");

        StorageReference listRef = FirebaseStorage.getInstance().getReference();
        listRef.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {
            @Override
            public void onSuccess(ListResult listResult) {
                int i=0;
                String imuri;

                for(StorageReference item : listResult.getItems()){
/*                    LinearLayout layout = (LinearLayout) findViewById(R.id.maskImageLayout);

                    ImageView iv = new ImageView(CaptureShowActivity.this);
                    iv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    layout.addView(iv);*/
                    i++;
                    getSupportActionBar().setTitle("item is : "+i);

                    switch (i){
                        case 1:

                            item.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    if (task.isSuccessful()){
                                        Glide.with(CaptureShowActivity.this).load(task.getResult()).into(im1);
                                    }

                                    im1.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Bintent.putExtra("url", task.getResult());
                                            startActivity(Bintent);

                                        }
                                    });

                                }
                            });

                            break;
                        case 2:
                            item.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    if (task.isSuccessful()){
                                        Glide.with(CaptureShowActivity.this).load(task.getResult()).into(im2);

                                    }
                                    im2.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Bintent.putExtra("url", task.getResult());
                                            startActivity(Bintent);

                                        }
                                    });
                                }
                            });



                            break;
                        case 3:
                            item.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    if (task.isSuccessful()){
                                        Glide.with(CaptureShowActivity.this).load(task.getResult()).into(im3);

                                    }
                                    im3.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Bintent.putExtra("url", task.getResult());
                                            startActivity(Bintent);
                                        }
                                    });
                                }
                            });

                            break;

                        case 4:
                            item.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    if (task.isSuccessful()){
                                        Glide.with(CaptureShowActivity.this).load(task.getResult()).into(im4);
                                    }
                                    im4.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Bintent.putExtra("url", task.getResult());
                                            startActivity(Bintent);

                                        }
                                    });
                                }
                            });


                            break;

                        case 5:
                            item.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    if (task.isSuccessful()){
                                        Glide.with(CaptureShowActivity.this).load(task.getResult()).into(im5);

                                    }
                                    im5.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Bintent.putExtra("url", task.getResult());
                                            startActivity(Bintent);

                                        }
                                    });
                                }
                            });


                            break;

                        case 6:
                            item.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    if (task.isSuccessful()){
                                        Glide.with(CaptureShowActivity.this).load(task.getResult()).into(im6);

                                    }
                                    im6.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Bintent.putExtra("url", task.getResult());
                                            startActivity(Bintent);

                                        }
                                    });
                                }
                            });


                            break;

                        case 7:
                            item.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    if (task.isSuccessful()){
                                        Glide.with(CaptureShowActivity.this).load(task.getResult()).into(im7);

                                    }
                                    im7.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Bintent.putExtra("url", task.getResult());
                                            startActivity(Bintent);

                                        }
                                    });
                                }
                            });


                            break;

                        case 8:
                            item.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    if (task.isSuccessful()){
                                        Glide.with(CaptureShowActivity.this).load(task.getResult()).into(im8);

                                    }
                                    im8.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Bintent.putExtra("url", task.getResult());
                                            startActivity(Bintent);

                                        }
                                    });
                                }
                            });


                            break;

                        case 9:
                            item.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    if (task.isSuccessful()){
                                        Glide.with(CaptureShowActivity.this).load(task.getResult()).into(im9);

                                    }
                                    im9.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Bintent.putExtra("url", task.getResult());
                                            startActivity(Bintent);

                                        }
                                    });
                                }
                            });


                            break;

                        case 10:
                            item.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    if (task.isSuccessful()){
                                        Glide.with(CaptureShowActivity.this).load(task.getResult()).into(im10);

                                    }
                                    im10.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Bintent.putExtra("url", task.getResult());
                                            startActivity(Bintent);

                                        }
                                    });
                                }
                            });


                            break;

                        case 11:
                            item.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    if (task.isSuccessful()){
                                        Glide.with(CaptureShowActivity.this).load(task.getResult()).into(im11);

                                    }
                                    im11.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Bintent.putExtra("url", task.getResult());
                                            startActivity(Bintent);

                                        }
                                    });
                                }
                            });


                            break;

                        case 12:
                            item.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    if (task.isSuccessful()){
                                        Glide.with(CaptureShowActivity.this).load(task.getResult()).into(im12);

                                    }
                                    im12.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Bintent.putExtra("url", task.getResult());
                                            startActivity(Bintent);

                                        }
                                    });
                                }
                            });


                            break;

                        case 13:
                            item.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    if (task.isSuccessful()){
                                        Glide.with(CaptureShowActivity.this).load(task.getResult()).into(im13);

                                    }
                                    im13.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Bintent.putExtra("url", task.getResult());
                                            startActivity(Bintent);

                                        }
                                    });
                                }
                            });


                            break;

                        case 14:
                            item.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    if (task.isSuccessful()){
                                        Glide.with(CaptureShowActivity.this).load(task.getResult()).into(im14);

                                    }
                                    im14.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Bintent.putExtra("url", task.getResult());
                                            startActivity(Bintent);

                                        }
                                    });
                                }
                            });


                            break;

                        case 15:
                            item.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    if (task.isSuccessful()){
                                        Glide.with(CaptureShowActivity.this).load(task.getResult()).into(im15);

                                    }
                                    im15.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Bintent.putExtra("url", task.getResult());
                                            startActivity(Bintent);

                                        }
                                    });
                                }
                            });


                            break;


                        default:




/*                    item.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                        @Override
                        public void onComplete(@NonNull Task<Uri> task) {
                            if (task.isSuccessful()){
                                Glide.with(CaptureShowActivity.this).load(task.getResult()).into(iv);
                            }else{
                                Toast.makeText(CaptureShowActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });*/
                }



            }
        }
    });
}}
