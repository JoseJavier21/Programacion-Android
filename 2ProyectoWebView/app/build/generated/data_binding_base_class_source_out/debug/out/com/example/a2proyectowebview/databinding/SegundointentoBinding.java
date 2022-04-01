// Generated by view binder compiler. Do not edit!
package com.example.a2proyectowebview.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.a2proyectowebview.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class SegundointentoBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageButton adelante;

  @NonNull
  public final ImageButton atras;

  @NonNull
  public final CheckBox compartir;

  @NonNull
  public final HorizontalScrollView horizontalScrollView;

  @NonNull
  public final FloatingActionButton otro;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final ImageButton recarga;

  @NonNull
  public final Spinner spinner;

  @NonNull
  public final FloatingActionButton twitter;

  @NonNull
  public final TextView urlview;

  @NonNull
  public final View view;

  @NonNull
  public final WebView webView;

  @NonNull
  public final FloatingActionButton whasap;

  private SegundointentoBinding(@NonNull ConstraintLayout rootView, @NonNull ImageButton adelante,
      @NonNull ImageButton atras, @NonNull CheckBox compartir,
      @NonNull HorizontalScrollView horizontalScrollView, @NonNull FloatingActionButton otro,
      @NonNull ProgressBar progressBar, @NonNull ImageButton recarga, @NonNull Spinner spinner,
      @NonNull FloatingActionButton twitter, @NonNull TextView urlview, @NonNull View view,
      @NonNull WebView webView, @NonNull FloatingActionButton whasap) {
    this.rootView = rootView;
    this.adelante = adelante;
    this.atras = atras;
    this.compartir = compartir;
    this.horizontalScrollView = horizontalScrollView;
    this.otro = otro;
    this.progressBar = progressBar;
    this.recarga = recarga;
    this.spinner = spinner;
    this.twitter = twitter;
    this.urlview = urlview;
    this.view = view;
    this.webView = webView;
    this.whasap = whasap;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static SegundointentoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static SegundointentoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.segundointento, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static SegundointentoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.adelante;
      ImageButton adelante = ViewBindings.findChildViewById(rootView, id);
      if (adelante == null) {
        break missingId;
      }

      id = R.id.atras;
      ImageButton atras = ViewBindings.findChildViewById(rootView, id);
      if (atras == null) {
        break missingId;
      }

      id = R.id.compartir;
      CheckBox compartir = ViewBindings.findChildViewById(rootView, id);
      if (compartir == null) {
        break missingId;
      }

      id = R.id.horizontalScrollView;
      HorizontalScrollView horizontalScrollView = ViewBindings.findChildViewById(rootView, id);
      if (horizontalScrollView == null) {
        break missingId;
      }

      id = R.id.otro;
      FloatingActionButton otro = ViewBindings.findChildViewById(rootView, id);
      if (otro == null) {
        break missingId;
      }

      id = R.id.progressBar;
      ProgressBar progressBar = ViewBindings.findChildViewById(rootView, id);
      if (progressBar == null) {
        break missingId;
      }

      id = R.id.recarga;
      ImageButton recarga = ViewBindings.findChildViewById(rootView, id);
      if (recarga == null) {
        break missingId;
      }

      id = R.id.spinner;
      Spinner spinner = ViewBindings.findChildViewById(rootView, id);
      if (spinner == null) {
        break missingId;
      }

      id = R.id.twitter;
      FloatingActionButton twitter = ViewBindings.findChildViewById(rootView, id);
      if (twitter == null) {
        break missingId;
      }

      id = R.id.urlview;
      TextView urlview = ViewBindings.findChildViewById(rootView, id);
      if (urlview == null) {
        break missingId;
      }

      id = R.id.view;
      View view = ViewBindings.findChildViewById(rootView, id);
      if (view == null) {
        break missingId;
      }

      id = R.id.webView;
      WebView webView = ViewBindings.findChildViewById(rootView, id);
      if (webView == null) {
        break missingId;
      }

      id = R.id.whasap;
      FloatingActionButton whasap = ViewBindings.findChildViewById(rootView, id);
      if (whasap == null) {
        break missingId;
      }

      return new SegundointentoBinding((ConstraintLayout) rootView, adelante, atras, compartir,
          horizontalScrollView, otro, progressBar, recarga, spinner, twitter, urlview, view,
          webView, whasap);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}